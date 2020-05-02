package com.coursework.makegame.controllers;
import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.entities.UpdateStatus;
import com.coursework.makegame.services.PlayStatusService;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation
        .RequestMapping;
import org.springframework.web.bind.annotation
        .RequestMethod;
import org.springframework.web.bind.annotation
        .RestController;
import static org.springframework.http.MediaType
        .APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(path = "/", produces =
        {APPLICATION_JSON_VALUE})
public class PlayStatusController {
    @Autowired
    private PlayStatusService playStatusService;

    @RequestMapping(value = "/sendplaystatus",
            method = RequestMethod.POST)
    public ResponseEntity<Object> sendPlayStatus(
            @RequestBody PlayStatus playStatus) {
        UpdateStatus updateStatus = playStatusService
                .updatingStatus(playStatus);
        if (updateStatus != null) {
            return ResponseEntity.ok().body(updateStatus);
        } else {
            return ResponseEntity.ok().body(
                    "Map is not found");
        }
    }
}
