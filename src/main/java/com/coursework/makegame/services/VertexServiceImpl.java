package com.coursework.makegame.services;
import com.coursework.makegame.entities.Vertex;
import com.coursework.makegame.repositories
        .VertexRepository;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
@Service
public class VertexServiceImpl implements VertexService {
    @Autowired
    private VertexRepository vertexRepository;
    @Override
    public Vertex searchVertex(Set<Vertex> vertices,
                               Long id) {
        for (Vertex v : vertices) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
    @Override
    public void saveVertexes(Set<Vertex> vertices) {
        vertices.forEach(v -> vertexRepository.save(v));
    }
}
