package com.movie.review_blogging_application.movie.service.Impl;

import com.movie.review_blogging_application.movie.dto.MovieDTO;
import com.movie.review_blogging_application.movie.dto.MovieUpdateDTO;
import com.movie.review_blogging_application.movie.entity.Movie;
import com.movie.review_blogging_application.movie.exception.MovieNotFoundException;
import com.movie.review_blogging_application.movie.mapper.MovieMapper;
import com.movie.review_blogging_application.movie.repository.MovieRepository;
import com.movie.review_blogging_application.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie create(MovieDTO movieDTO) {
        Movie movie = MovieMapper.toMovie(movieDTO);
        persists(movie);
        return movie;
    }

    @Override
    public Movie getById(long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Movie update( long id, MovieUpdateDTO movieUpdateDTO) {
        Movie movie = getMovie(id);
        return updateMovieDetail(id,movie, movieUpdateDTO);
    }

    private Movie updateMovieDetail(long id, Movie existingMovie, MovieUpdateDTO movieUpdateDTO) {
        Movie movie = new Movie();
        MovieMapper.copyFromExistingMovie(existingMovie,movie);
        MovieMapper.copyMovieUpdateDTO(movieUpdateDTO,movie);
        movie.updateTagVersion();
        persists(movie);
        return movie;
    }

    private Movie persists(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    public Movie getMovie(long id) {
        return movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException(id));
    }

    @Override
    public Movie delete(long id) {
        Movie movie = getMovie(id);
        movie.setIsDeleted(Boolean.TRUE);
        persists(movie);
        return movie;
    }

}
