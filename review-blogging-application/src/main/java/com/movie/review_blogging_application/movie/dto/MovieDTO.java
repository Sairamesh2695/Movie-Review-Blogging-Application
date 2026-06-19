package com.movie.review_blogging_application.movie.dto;

import lombok.Data;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String director;
    private String genre;
    private int releaseYear;
    private String description;
    private String posterUrl;
    private Double averageRating;
    private Long totalReviews;
}
