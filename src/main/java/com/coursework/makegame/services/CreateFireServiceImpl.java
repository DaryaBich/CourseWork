package com.coursework.makegame.services;

import com.coursework.makegame.entities.Fire;
import com.coursework.makegame.entities.Graph;
import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.entities.Vertex;
import com.coursework.makegame.repositories.GraphRepository;
import com.coursework.makegame.repositories.VertexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CreateFireServiceImpl implements CreateFireService {
    @Autowired
    private GraphService graphService;
    @Autowired
    private VertexRepository vertexRepository;

    @Override
    public Fire createNewFires(PlayStatus playStatus) {
        Long graphId = playStatus.getGraphId();
        Long userLocation = playStatus.getUserLocation();
        Graph graph = graphService.getGraph(graphId);
        Set<Long> fires = graphService.getVertexWithFire(graph);
        Set<Long> exits = graphService.getExits(graph);
        // будет ли новый пожар
        if ((new Random()).nextInt(101) > 69 && fires.size() > 1 || fires.size() == 0) {
            long newFire = searchRandomRoomToFire(fires, exits, graph.getVertices(), userLocation);
            Vertex vertex = vertexRepository.findById(newFire);
            vertex.setFire(true);
            vertexRepository.save(vertex);
            return new Fire(Collections.singletonList(newFire));
        } else {
            return null;
        }
    }

    @Override
    public Long searchRandomRoomToFire(Set<Long> haveFire, Set<Long> exits, Set<Vertex> vertices, Long userLocation) {
        Random random = new Random();
        Set<Long> canBeFire = verticesNearFire(vertices, haveFire); // вершины рядом с огнем
        long roomNumber;
        int accum = 0;
        do {
            roomNumber = (long) random.nextInt(vertices.size() + 1);
            if (canBeFire.contains(roomNumber) && !exits.contains(roomNumber) && roomNumber != userLocation) {
                return roomNumber;
            }
            if (accum > 100 && !exits.contains(roomNumber) && roomNumber != userLocation) {
                return roomNumber;
            }
            accum++;
        } while (true);
    }

    @Override
    public Set<Long> verticesNearFire(Set<Vertex> vertices, Set<Long> fires) {
        Set<Long> nearFire = new HashSet<>();
        for (Vertex v : vertices) {
            if (fires.contains(v.getId())) {
                nearFire.addAll(v.getNearByVertex());
            }
        }
        return nearFire;
    }
}