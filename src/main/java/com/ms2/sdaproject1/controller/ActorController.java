package com.ms2.sdaproject1.controller;

import com.ms2.sdaproject1.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //mówimy że w tej klasie będą rządania HTTP
public class ActorController {
    private final IActorRepository actorRepository;

    @Autowired
    public ActorController(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("actor")
    public String readAllActor(Model model){
        model.addAttribute("actorsVariable", actorRepository.findAll());
        return "actors";
    }
}
