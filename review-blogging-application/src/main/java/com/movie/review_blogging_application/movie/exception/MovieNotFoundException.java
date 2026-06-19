package com.movie.review_blogging_application.movie.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(long id) {
        super(String.format("Movie id %d does not exist", id));
    }

    public MovieNotFoundException(){super("No Movies found");}
    public MovieNotFoundException(String id){
        super(String.format("Movie with id %s does not exist", id));
    }
}
