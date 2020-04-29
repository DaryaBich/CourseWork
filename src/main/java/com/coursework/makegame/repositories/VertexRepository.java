package com.coursework.makegame.repositories;

import com.coursework.makegame.entities.Graph;
import com.coursework.makegame.entities.Vertex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface VertexRepository extends JpaRepository<Vertex, Integer> {
    @Query(value = "select v from Vertex v where graphId = ?1")
    List<Vertex> findByGraphId(Long graphId);
    @Query(value = "select v from Vertex v where id = ?1")
    Vertex findById(Long id);

}
