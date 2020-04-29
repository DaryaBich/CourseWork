package com.coursework.makegame.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode
public class StartPlay { // приходит для создания игры, самый первый запрос
    private Set<Vertex> vertexes;

    public StartPlay(Set<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public StartPlay() {
    }
}
