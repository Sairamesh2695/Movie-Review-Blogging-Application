package com.movie.review_blogging_application.movie.repository;

import com.movie.review_blogging_application.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
