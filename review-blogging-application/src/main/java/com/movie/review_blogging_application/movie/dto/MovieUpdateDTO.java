package com.movie.review_blogging_application.movie.dto;

import lombok.Data;

@Data
public class MovieUpdateDTO {
    private String title;
    private String director;
    private String genre;
    private int releaseYear;
    private String description;
}
