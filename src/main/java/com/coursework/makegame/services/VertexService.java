package com.coursework.makegame.services;
import com.coursework.makegame.entities.Vertex;
import java.util.Set;
public interface VertexService {
    Vertex searchVertex(Set<Vertex> vertices, Long id);
    void saveVertexes(Set<Vertex> vertices);
}
