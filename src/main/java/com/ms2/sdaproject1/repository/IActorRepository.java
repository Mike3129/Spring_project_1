package com.ms2.sdaproject1.repository;

import com.ms2.sdaproject1.dto.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActorRepository extends CrudRepository<Actor,Long> {

}
