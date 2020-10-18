package com.ms2.sdaproject1.service;

import com.ms2.sdaproject1.repository.IMovieRepository;
import com.ms2.sdaproject1.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private  final IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findMovies(){
        return this.movieRepository.findAll();
    }

    public void deleteById(Integer id){
        this.movieRepository.deleteById(id);
    }
}
