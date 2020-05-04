package com.coursework.makegame.services;
import com.coursework.makegame.entities.Fire;
import com.coursework.makegame.entities.Graph;
import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.entities.Vertex;
import com.coursework.makegame.repositories
        .VertexRepository;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CreateFireServiceImpl
        implements CreateFireService {
    @Autowired
    private GraphService graphService;
    @Autowired
    private VertexRepository vertexRepository;
    @Override
    public Fire createNewFires(PlayStatus playStatus) {
        Long graphId = playStatus.getGraphId();
        Long userLocation = playStatus.getUserLocation();
        Graph graph = graphService.getGraph(graphId);
        Set<Long> fires = graphService
                .getVertexWithFire(graph);
        Set<Long> exits = graphService
                .getExits(graph);
        if ((new Random()).nextInt(101) > 59 &&
                fires.size() > 0 || fires.size() == 0) {
            long newFire = searchRandomRoomToFire(fires,
                    exits, graph.getVertices(),
                    userLocation);
            if (newFire == -1){
                return new Fire(new ArrayList<>());
            }
            Vertex vertex = vertexRepository
                    .findById(newFire);
            vertex.setFire(true);
            vertexRepository.save(vertex);
            return new Fire(Collections
                    .singletonList(newFire));
        } else {
            return new Fire(new ArrayList<>());
        }
    }
    @Override
    public Long searchRandomRoomToFire(Set<Long> haveFire,
                                       Set<Long> exits,
                                       Set<Vertex> vertices,
                                       Long userLocation) {
        Set<Long> canBeFire = new HashSet<>();
        if (haveFire.size() == 0) {
            for (Vertex v : vertices) {
                canBeFire.add(v.getId());
            }
        } else {
            canBeFire =
                    verticesNearFire(vertices, haveFire);
        }
        long roomNumber;
        int accum = 0;
        do {
            roomNumber = (long) (new Random())
                    .nextInt(vertices.size());
            if (canBeFire.contains(roomNumber) &&
                    roomNumber != userLocation &&
            !haveFire.contains(roomNumber)) {
                return roomNumber;
            }
            if (accum > vertices.size() * 3) {
                return (long) -1;
            }
            accum++;
        } while (true);
    }
    @Override
    public Set<Long> verticesNearFire(Set<Vertex> vertices,
                                      Set<Long> fires) {
        Set<Long> nearFire = new HashSet<>();
        for (Vertex v : vertices) {
            if (fires.contains(v.getId())) {
                nearFire.addAll(v.getNearByVertex());
            }
        }
        return nearFire;
    }
}
