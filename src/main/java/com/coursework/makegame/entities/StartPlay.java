package com.coursework.makegame.entities;
import lombok.Data;
import java.util.Set;
@Data
public class StartPlay {
    private Set<Vertex> vertexes;
    public StartPlay() {
    }
}