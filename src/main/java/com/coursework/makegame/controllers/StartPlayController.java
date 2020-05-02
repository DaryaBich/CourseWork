package com.coursework.makegame.controllers;
import com.coursework.makegame.entities.StartPlay;
import com.coursework.makegame.services.GraphService;
import com.coursework.makegame.services.VertexService;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType
        .APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType
        .APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(path = "/", produces =
        {APPLICATION_JSON_UTF8_VALUE,
                APPLICATION_JSON_VALUE})
public class StartPlayController {
    @Autowired
    private GraphService graphService;
    @Autowired
    private VertexService vertexService;
    @RequestMapping(value = "/sendstartplay",
            method = RequestMethod.POST)
    public ResponseEntity<Object> sendStartPlay(
            @RequestBody StartPlay startPlay) {
        graphService.createGraph(startPlay);
        vertexService.saveVertexes(startPlay.getVertexes());
        return ResponseEntity.ok().body("Map is created");
    }
}
