package com.coursework.makegame.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PlayStatus { // приходит каждый раз после хода
    private long userLocation;
    private long graphId;
}
