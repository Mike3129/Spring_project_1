package com.ms2.sdaproject1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

// w tej klasie tworzymy klasę metod MovieRepository
public class MovieRepository {
    Map<Integer,Movie> filmy = new HashMap<>();

    public void addMovie(Movie movie){
        filmy.put(movie.getId(),movie);
    }

    public Movie getMovie(Integer id){
        return filmy.get(id);
    }

    public List<Movie> movieList (){
        return List.copyOf(filmy.values());
    }


}
