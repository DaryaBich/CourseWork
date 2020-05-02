package com.coursework.makegame.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "vertex")
public class Vertex {
    @Id
    private long id;
    private long graphId;
    @ElementCollection
    private List<Long> nearByVertex;
    private boolean isExit;
    private boolean isFire;
    public Vertex() {
    }
    public Vertex(long id, long graphId,
                  List<Long> nearByVertex,
                  boolean isExit, boolean isFire) {
        this.id = id;
        this.graphId = graphId;
        this.nearByVertex = nearByVertex;
        this.isExit = isExit;
        this.isFire = isFire;
    }
}