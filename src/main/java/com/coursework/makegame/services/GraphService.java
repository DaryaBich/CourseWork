package com.coursework.makegame.services;
import com.coursework.makegame.entities.Graph;
import com.coursework.makegame.entities.StartPlay;
import java.util.List;
import java.util.Set;
public interface GraphService {
    Graph getGraph(Long id);
    List<Graph> getAllGraphs();
    void createGraph(StartPlay startPlay);
    Set<Long> getVertexWithFire(Graph graph);
    Set<Long> getExits(Graph graph);
}
