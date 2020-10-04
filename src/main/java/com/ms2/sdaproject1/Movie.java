package com.ms2.sdaproject1;

import java.util.Random;

public class Movie {
    String title;
    Integer year;
    Integer id;

    public Movie(String title, Integer year) {
        this.title = title;
        this.year = year;
        Random generator = new Random();
        id=generator.nextInt(100);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
