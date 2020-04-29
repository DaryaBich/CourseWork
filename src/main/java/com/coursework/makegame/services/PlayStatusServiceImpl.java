package com.coursework.makegame.services;

import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.entities.UpdateStatus;
import com.coursework.makegame.repositories.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayStatusServiceImpl implements PlayStatusService {
    @Autowired
    private UpdateStatusService updateStatusService;
    @Autowired
    private SearchWayService searchWayService;
    @Autowired
    private GraphRepository graphRepository;
    @Autowired
    private GraphService graphService;

    @Override
    public long getUserLocation(PlayStatus playStatus) {
        return playStatus.getUserLocation();
    }

    public UpdateStatus updatingStatus(PlayStatus playStatus) {
        if (graphRepository.findGraphs().size()>0){
            List<Long> way = searchWayService.makeWay(playStatus.getGraphId(), playStatus.getUserLocation());
            UpdateStatus updateStatus = updateStatusService.createUpdateStatus(way);
            if (way.size() == 0){
                updateStatus.setBlocked(true);
            }
            else if (graphService.getExits(graphRepository.findGraph(playStatus.getGraphId()))
                    .contains(way.get(way.size() - 1))){
                updateStatus.setExit(true);
            }
            return updateStatus;
        }
        else{
            return null;
        }
    }
}
