package com.coursework.makegame.services;
import com.coursework.makegame.entities.Graph;
import com.coursework.makegame.entities.StartPlay;
import com.coursework.makegame.entities.Vertex;
import com.coursework.makegame.repositories
        .GraphRepository;
import com.coursework.makegame.repositories
        .VertexRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class GraphServiceImpl implements GraphService {
    private static final Logger logger =
            LogManager.getLogger(GraphServiceImpl.class);
    @Autowired
    private GraphRepository graphRepository;
    @Autowired
    private VertexRepository vertexRepository;
    @Override
    public void createGraph(StartPlay startPlay) {
        logger.info("creating Graph with vertexes = " +
                startPlay.getVertexes());
        Graph graph =
                new Graph((long) graphRepository
                        .findGraphs().size(),
                        startPlay.getVertexes());
        graphRepository.save(graph);
    }
    @Override
    public Graph getGraph(Long id) {
        logger.info("getting Graph with id " + id);
        Graph graph = graphRepository.findGraph(id);
        Set<Vertex> vertices = new HashSet<>();
        vertices.addAll(vertexRepository.findByGraphId(id));
        graph.setVertices(vertices);
        return graph;
    }
    @Override
    public List<Graph> getAllGraphs() {
        logger.info("getting Graphs");
        return graphRepository.findGraphs();
    }
    @Override
    public Set<Long> getVertexWithFire(Graph graph) {
        Set<Long> fires = new HashSet<>();
        graph.getVertices().forEach(v -> {
            if(v.isFire()){
                fires.add(v.getId());
            }
        });
        return fires;
    }
    @Override
    public Set<Long> getExits(Graph graph) {
        Set<Long> exits = new HashSet<>();
        graph.getVertices().forEach(v -> {
            if(v.isExit()){
                exits.add(v.getId());
            }
        });
        return exits;
    }
}