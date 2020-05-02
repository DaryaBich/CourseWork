package com.coursework.makegame.services;
import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.entities.UpdateStatus;
import com.coursework.makegame.repositories.GraphRepository;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PlayStatusServiceImpl
        implements PlayStatusService {
    @Autowired
    private SearchWayService searchWayService;
    @Autowired
    private GraphRepository graphRepository;
    @Override
    public long getUserLocation(PlayStatus playStatus) {
        return playStatus.getUserLocation();
    }
    public UpdateStatus updatingStatus(
            PlayStatus playStatus) {
        if (graphRepository.findGraphs().size()>0){
            List<Long> way = searchWayService
                    .makeWay(playStatus.getGraphId(),
                            playStatus.getUserLocation());
            UpdateStatus updateStatus =
                    new UpdateStatus(way, way.size() == 1,
                            way.size()==0);
            return updateStatus;
        }
        else{
            return null;
        }
    }
}
