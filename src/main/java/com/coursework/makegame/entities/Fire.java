package com.coursework.makegame.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;
@Data
@EqualsAndHashCode
public class Fire {
    List<Long> newFires;
    public Fire(List<Long> newFires) {
        this.newFires = newFires;
    }
}
