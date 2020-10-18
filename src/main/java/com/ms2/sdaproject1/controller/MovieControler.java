package com.ms2.sdaproject1.controller;

import com.ms2.sdaproject1.dto.Movie;
import com.ms2.sdaproject1.repository.MovieNotFoundException;
import com.ms2.sdaproject1.repository.MovieRepository;
import com.ms2.sdaproject1.repository.MovieTitleExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class MovieControler {

    @Autowired //gdy nie ma konstruktora MovieRepository w klasie to trzeba to dodać.
    MovieRepository movieRepository;

    //dodanie filmu do bazy/listy
    @ResponseStatus(HttpStatus.CONFLICT) //ten response status odnosi się do Exception handler
    @ExceptionHandler(MovieTitleExcpetion.class)
    //trzeba napisać wyjątek w movie repository a następnie się do niego odnieść, usta klasa poniżej musi być
    public void error(){
    }
    @ResponseStatus(HttpStatus.CREATED) //ten response status odnosi się do postmappingu
    @PostMapping("/movies")
    public void post(@RequestBody Movie movie) throws MovieTitleExcpetion {
    movieRepository.addMovie(movie);
    }

    //wyświetlanie danego filmy o podanym id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/movies/{id}")
    //@PathVariable odnosi się do ID podanego w body wyżej
    public String filmId (@PathVariable Integer id, Model model) throws MovieNotFoundException{
        model.addAttribute("movie",movieRepository.getMovie(id));
        return "movie";
    }

    //wyświetlanie całej listy
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/movies/all")
    public List<Movie> list (){
         return movieRepository.movieList();
    }

    //modyfikacja filmu o podanym ID
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieNotFoundException.class)
    public void error2(){
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/movies/{id}")
    public void update(@PathVariable Integer id,@RequestBody Movie movie) throws MovieNotFoundException{
        movieRepository.updateMovie(id,movie);
    }

    //usuwanie filmu o podanym id
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/movies/{id}")
    public void delete(@PathVariable Integer id) throws MovieNotFoundException{
        movieRepository.deleteMovie(id);
    }

    //testowy controler dla thymleaf
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test")
    public String test (Model model){
        model.addAttribute("hello","JIM");
        return "movies";
    }

}
