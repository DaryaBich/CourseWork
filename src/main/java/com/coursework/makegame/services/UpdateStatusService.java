package com.coursework.makegame.services;

import com.coursework.makegame.entities.UpdateStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UpdateStatusService {
    UpdateStatus createUpdateStatus(List<Long> way);

    UpdateStatus updateWay(List<Long> newWay, UpdateStatus updateStatus);

    UpdateStatus setIsExit(UpdateStatus updateStatus, boolean isExit);

    UpdateStatus setIsBlocked(UpdateStatus updateStatus, boolean isBlocked);

    List<Long> getWay(UpdateStatus updateStatus);
}
