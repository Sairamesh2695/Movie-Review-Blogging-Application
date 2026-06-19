package com.movie.review_blogging_application.movie.mapper;

import com.movie.review_blogging_application.movie.dto.MovieDTO;
import com.movie.review_blogging_application.movie.dto.MovieUpdateDTO;
import com.movie.review_blogging_application.movie.entity.Movie;

public class MovieMapper {
    private MovieMapper(){}

    public static Movie toMovie(MovieDTO movieDTO){
        Movie movie = new Movie();
        if(movieDTO != null){
            movie.setId(movieDTO.getId());
            movie.setTitle(movieDTO.getTitle());
            movie.setDirector(movieDTO.getDirector());
            movie.setGenre(movieDTO.getGenre());
            movie.setReleaseYear(movieDTO.getReleaseYear());
            movie.setDescription(movieDTO.getDescription());
            movie.setPosterUrl(movieDTO.getPosterUrl());
        }
        return movie;
    }

    public static void copyFromExistingMovie(Movie src, Movie target) {
        if(src == null || target == null) return;
        target.setTitle(src.getTitle());
        target.setDirector(src.getDirector());
        target.setDescription(src.getDescription());
        target.setGenre(src.getGenre());
        target.setPosterUrl(src.getPosterUrl());
        target.setReleaseYear(src.getReleaseYear());
    }

    public static void copyMovieUpdateDTO(MovieUpdateDTO src, Movie target) {
        if(src == null || target == null) return;
        target.setTitle(src.getTitle());
        target.setDirector(src.getDirector());
        target.setGenre(src.getGenre());
        target.setDescription(src.getDescription());
        target.setReleaseYear(src.getReleaseYear());
    }
}
