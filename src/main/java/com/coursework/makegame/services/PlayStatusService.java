package com.coursework.makegame.services;

import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.entities.UpdateStatus;

public interface PlayStatusService {
    long getUserLocation(PlayStatus playStatus);

    UpdateStatus updatingStatus(PlayStatus playStatus);
}
