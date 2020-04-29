package com.coursework.makegame.controllers;

import com.coursework.makegame.services.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/", produces = {APPLICATION_JSON_UTF8_VALUE, APPLICATION_JSON_VALUE})
public class GraphController {
    @Autowired
    private GraphService graphService;

    @RequestMapping(value = "/getMap/{graphId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getMap(@PathVariable(value = "graphId") Long graphId) {
        return ResponseEntity.ok().body(graphService.getGraph(graphId));
    }
}
