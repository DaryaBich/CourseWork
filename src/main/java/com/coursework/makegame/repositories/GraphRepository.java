package com.coursework.makegame.repositories;

import com.coursework.makegame.entities.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphRepository extends JpaRepository<Graph, Integer> {
    @Query(value = "select g from Graph g")
    List<Graph> findGraphs();

    @Query(value = "select g from Graph g where id = ?1")
    Graph findGraph(Long id);
}
