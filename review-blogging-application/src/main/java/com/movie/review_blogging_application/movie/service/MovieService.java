package com.movie.review_blogging_application.movie.service;

import com.movie.review_blogging_application.movie.dto.MovieDTO;
import com.movie.review_blogging_application.movie.dto.MovieUpdateDTO;
import com.movie.review_blogging_application.movie.entity.Movie;

public interface MovieService {
    Movie create(MovieDTO movieDTO);

    Movie getById(long id);

    Movie update(long id, MovieUpdateDTO movieUpdateDTO);

    Movie getMovie(long id);

    Movie delete(long id);
}
