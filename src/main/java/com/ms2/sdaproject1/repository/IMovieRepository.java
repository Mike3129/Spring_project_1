package com.ms2.sdaproject1.repository;

import com.ms2.sdaproject1.dto.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface IMovieRepository extends CrudRepository<Movie,Integer> {

    Optional<Movie> findByTitle(String title);

    List<Movie> findAll();

}
