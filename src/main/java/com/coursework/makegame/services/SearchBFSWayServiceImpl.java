package com.coursework.makegame.services;

import com.coursework.makegame.entities.Graph;
import com.coursework.makegame.entities.Vertex;
import com.coursework.makegame.repositories.GraphRepository;
import com.coursework.makegame.repositories.VertexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchBFSWayServiceImpl implements SearchWayService {
    @Autowired
    private GraphRepository graphRepository;
    @Autowired
    private GraphService graphService;
    @Autowired
    private VertexService vertexService;
    @Autowired
    private VertexRepository vertexRepository;

    @Override
    public List<Long> makeWay(Long graphId, Long userLocation) {
        List<Long> way;
        Graph graph = graphRepository.findGraph(graphId);
        Set<Vertex> vertices = new HashSet<>();
        vertices.addAll(vertexRepository.findByGraphId(graphId));
        graph.setVertices(vertices);
        Set<Long> exits = graphService.getExits(graph);
        if (exits.contains(userLocation)) {
            return Collections.singletonList(userLocation);
        }
        return bfsSearch(graph.getVertices(), exits, graphService.getVertexWithFire(graph), userLocation);
    }

    private List<Long> bfsSearch(Set<Vertex> vertices, Set<Long> exits, Set<Long> roomsWithFire,
                                 Long userLocation) {
        List<Long> shortestWay = new ArrayList<>();
        for (Long vertex : exits) {
            List<Long> searchedWay = bfs(vertices, roomsWithFire, userLocation, vertex);
            if (searchedWay.size() < shortestWay.size() && searchedWay.size() > 0 ||
                    shortestWay.size() == 0) {
                shortestWay = searchedWay;
            }
        }
        return shortestWay;
    }

    private List<Long> bfs(Set<Vertex> vertices, Set<Long> roomsWithFire, Long userLocation,
                           Long finish) {
        List<Long> way = new ArrayList<>();
        Map<Long, Long> distance = new HashMap<>();
        Map<Long, Long> parent = new HashMap<>();
        vertices.forEach(v -> {
            distance.put(v.getId(), Long.MAX_VALUE);
            parent.put(v.getId(), (long) -1);
        });
        distance.put(userLocation, (long) 0);
        Queue<Long> queue = new ArrayDeque<>();
        queue.add(userLocation);
        while (queue.size() > 0) {
            Vertex vertex = vertexService.searchVertex(vertices, queue.poll());
            for (Long v : vertex.getNearByVertex()) {
                if (distance.get(v) > distance.get(vertex.getId()) + 1) {
                    distance.put(v, distance.get(vertex.getId()) + 1);
                    parent.put(v, vertex.getId());
                    queue.add(v);
                }
            }
        }
        if (distance.get(finish) != Long.MAX_VALUE) {
            while (finish != -1) {
                way.add(finish);
                finish = parent.get(finish);
            }
            Collections.reverse(way);
        }
        return way;
    }
}
