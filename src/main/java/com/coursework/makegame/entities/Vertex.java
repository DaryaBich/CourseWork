package com.coursework.makegame.entities;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
}