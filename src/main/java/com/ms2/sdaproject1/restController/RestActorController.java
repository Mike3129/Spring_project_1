package com.ms2.sdaproject1.restController;

import com.ms2.sdaproject1.dto.Actor;
import com.ms2.sdaproject1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class RestActorController {

    private final ActorService actorService;


    @Autowired
    public RestActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    // /api/actors
    @GetMapping
    public List<Actor> findActors(){
        return actorService.findActors();
    }
}
