package com.ms2.sdaproject1.Controler;

import com.ms2.sdaproject1.Movie;
import com.ms2.sdaproject1.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class MovieControler {
    @Autowired //gdy nie ma konstruktora MovieRepository w klasie to trzeba to dodać.
    MovieRepository movieRepository;

    //dodanie filmu do bazy/listy
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movies")
    public void post(@RequestBody Movie movie){
    movieRepository.addMovie(movie);
    }

    //wyświetlanie danego filmy o podanym id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/movies/{id}")
    public Movie filmId (@PathVariable Integer id){
    //@PathVariable odnosi się do ID podanego w body wyżej
        return movieRepository.getMovie(id);
    }

    //wyświetlanie całej listy
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/movies/all")
    public List<Movie> list (){
         return movieRepository.movieList();
    }

    //modyfikacja filmu o podanym ID
    @PutMapping("/movies/{id}")
    public void update(@PathVariable Integer id,@RequestBody Movie movie){
        movieRepository.updateMovie(id,movie);
    }

    //usuwanie filmu o podanym id
    @DeleteMapping("/movies/{id}")
    public void delete(@PathVariable Integer id){
        movieRepository.deleteMovie(id);
    }

}
