package com.coursework.makegame.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "vertex")
public class Vertex {
    @Id
    @GeneratedValue
    private long id;
    private long localId;
    private long graphId;
    @ElementCollection
    private List<Long> nearByVertex;
    private boolean isExit;
    private boolean isFire;
    public Vertex() {
    }
}