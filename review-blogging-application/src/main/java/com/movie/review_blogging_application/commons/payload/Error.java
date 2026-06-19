package com.movie.review_blogging_application.commons.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Error {
    String message;
    public Error(String message){this.message = message;}
    public String toString(){return this.message;}
    public String message(){return this.message;}
}
