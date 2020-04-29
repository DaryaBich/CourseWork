package com.coursework.makegame.services;

import com.coursework.makegame.entities.UpdateStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UpdateStatusServiceImpl implements UpdateStatusService {
    @Override
    public UpdateStatus createUpdateStatus(List<Long> way) {
        return new UpdateStatus(way, way.size() == 1, way.size()==0);
    }


    @Override
    public UpdateStatus updateWay(List<Long> newWay, UpdateStatus updateStatus) {
        updateStatus.setWay(newWay);
        return updateStatus;
    }

    @Override
    public UpdateStatus setIsExit(UpdateStatus updateStatus, boolean isExit) {
        updateStatus.setExit(isExit);
        return updateStatus;
    }

    @Override
    public UpdateStatus setIsBlocked(UpdateStatus updateStatus, boolean isBlocked) {
        updateStatus.setBlocked(isBlocked);
        return updateStatus;
    }

    @Override
    public List<Long> getWay(UpdateStatus updateStatus) {
        return updateStatus.getWay();
    }
}
