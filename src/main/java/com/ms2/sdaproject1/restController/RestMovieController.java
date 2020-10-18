package com.ms2.sdaproject1.restController;

import com.ms2.sdaproject1.dto.Movie;
import com.ms2.sdaproject1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
//zwracają dane w jasonie
public class RestMovieController {

    private final MovieService movieService;

    @Autowired
    public RestMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // /api/movies
    @GetMapping
    public List<Movie> findMovies(){
        return movieService.findMovies();
    }

    // /api/movies/{id}
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteById(id);
    }
}
