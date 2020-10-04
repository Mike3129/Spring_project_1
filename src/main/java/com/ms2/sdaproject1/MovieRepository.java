package com.ms2.sdaproject1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

// w tej klasie tworzymy klasę metod MovieRepository
public class MovieRepository {
    Map<Integer,Movie> filmy = new HashMap<>();

    public void addMovie(Movie movie) throws MovieTitleExcpetion{

        //stream sprawdzający czy w bazie znajduje się film o podanym tytule
        if (filmy.values().stream().anyMatch(m -> m.getTitle().equals(movie.getTitle())))
            throw new MovieTitleExcpetion();
        filmy.put(movie.getId(),movie);
    }

    public Movie getMovie(Integer id) throws MovieNotFoundException {
        if (filmy.values().stream().noneMatch(m ->m.getId().equals(id)))
            throw new MovieNotFoundException();
        return filmy.get(id);
    }

    public List<Movie> movieList (){
        return List.copyOf(filmy.values());
    }

    public void updateMovie(Integer id, Movie movie)throws MovieNotFoundException{
        if (filmy.values().stream().anyMatch(m -> m.getTitle().equals(movie.getTitle()))){
            throw new MovieNotFoundException();
        }else{
            // update samego tytułu
            filmy.get(id).setTitle(movie.getTitle());
        }
    }

    public void deleteMovie (Integer id) throws MovieNotFoundException{
        if (filmy.values().stream().noneMatch(m ->m.getId().equals(id)))
            throw new MovieNotFoundException();
        filmy.remove(id);
    }


}
