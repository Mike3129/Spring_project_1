package com.ms2.sdaproject1.service;

import com.ms2.sdaproject1.dto.Actor;
import com.ms2.sdaproject1.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final IActorRepository actorRepository;

    @Autowired
    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findActors(){
        return (List<Actor>) this.actorRepository.findAll();
    }
}
