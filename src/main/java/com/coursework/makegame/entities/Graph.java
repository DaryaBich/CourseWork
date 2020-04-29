package com.coursework.makegame.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "graph")
public class Graph { // хранится на сервере - модель игры
    @Id
    private Long id;


    @Transient
    private Set<Vertex> vertices;

//    @Transient
//    private Set<Long> vertexWithFire;
//
//    @Transient
//    private Set<Long> exits;

    public Graph() {
    }

    public Graph(Long id, Set<Vertex> vertices) {
        this.id = id;
        this.vertices = vertices;
    }

}
