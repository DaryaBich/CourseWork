package com.coursework.makegame.controllers;
import com.coursework.makegame.entities.PlayStatus;
import com.coursework.makegame.services.CreateFireService;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType
        .APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType
        .APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(path = "/",
        produces = {APPLICATION_JSON_UTF8_VALUE,
                APPLICATION_JSON_VALUE})
public class CreateFireController {
    @Autowired
    private CreateFireService createFireService;
    @RequestMapping(value = "/createfire",
            method = RequestMethod.POST)
    public ResponseEntity<Object> sendPlayStatus(
            @RequestBody PlayStatus playStatus) {
        return ResponseEntity.ok().body(createFireService
                .createNewFires(playStatus));
    }
}
