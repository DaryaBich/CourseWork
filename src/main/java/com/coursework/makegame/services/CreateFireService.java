package com.coursework.makegame.services;

import com.coursework.makegame.entities.Fire;
import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.entities.Vertex;

import java.util.Set;

public interface CreateFireService {
    Fire createNewFires(PlayStatus playStatus);

    Long searchRandomRoomToFire(Set<Long> haveFire, Set<Long> exits, Set<Vertex> vertices, Long userLocation);

    Set<Long> verticesNearFire(Set<Vertex> vertices, Set<Long> fires);
}
