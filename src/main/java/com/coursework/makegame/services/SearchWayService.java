package com.coursework.makegame.services;

import java.util.List;

public interface SearchWayService {
    List<Long> makeWay(Long graphId, Long userLocation);
}
