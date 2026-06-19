package com.movie.review_blogging_application.commons.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Payload {
    private String status;
    private int code;

    private Long id;
    private String message;
    private Object data;

    private Set<Error> errors;
}
