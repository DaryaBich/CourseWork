package com.coursework.makegame.entities;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
@Getter
@Setter
public class StartPlay {
    private Set<Vertex> vertexes;
    public StartPlay(Set<Vertex> vertexes) {
        this.vertexes = vertexes;
    }
    public StartPlay() {
    }
}