package com.movie.review_blogging_application.commons.payload;

import com.movie.review_blogging_application.commons.utils.ErrorUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.movie.review_blogging_application.commons.payload.Error;

import java.util.Objects;
import java.util.Set;

public interface PayloadBuilder {
    String SUCCESS = "success";
    String FAILURE = "failure";

    static ResponseEntity<Payload> ok(Object data){
        return ResponseEntity.ok(Payload.builder()
                .data(data)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());
    }

    static ResponseEntity<Payload> ok(String errorMessage){
        return ResponseEntity.ok(Payload.builder()
                .message(errorMessage)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());
    }

    static ResponseEntity<Payload> noContent(String errorMessage){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Payload.builder()
                .errors(Set.of(new Error(errorMessage)))
                .status(FAILURE)
                .code(HttpStatus.NO_CONTENT.value())
                .build());
    }

    static ResponseEntity<Payload> notFound(String errorMessage){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Payload.builder()
                .errors(Set.of(new Error(errorMessage)))
                .status(FAILURE)
                .code(HttpStatus.NOT_FOUND.value())
                .build());
    }

    static ResponseEntity<Payload> badRequest(Object errorMessage){
        Set<Error> errors;
        if(errorMessage instanceof Set<?> setOfErrorMessage){
            errors = ErrorUtils.errorTypeCast(setOfErrorMessage);
        }else if(errorMessage instanceof String error){
            errors = Set.of(new Error(error));
        }else{
            errors = Set.of(new Error(Objects.toString(errorMessage,"")));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(Payload.builder()
                .errors(errors)
                .status(FAILURE)
                .code(HttpStatus.NO_CONTENT.value())
                .build());
    }

    static ResponseEntity<Payload> created(Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Payload.builder()
                        .id(id)
                        .status(SUCCESS)
                        .code(HttpStatus.CREATED.value())
                        .build());
    }

    static ResponseEntity<Payload> updated(Long id){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(Payload.builder()
                        .id(id)
                        .status(SUCCESS)
                        .code(HttpStatus.OK.value())
                        .build());
    }

    static ResponseEntity<Payload> deleted(Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Payload.builder()
                        .id(id)
                        .message("Deleted Successfully")
                        .status(SUCCESS)
                        .code(HttpStatus.OK.value())
                        .build());
    }

    static ResponseEntity<Payload> unauthorized(String errorMessage){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Payload.builder()
                        .errors(Set.of(new Error(errorMessage)))
                        .status(FAILURE)
                        .code(HttpStatus.UNAUTHORIZED.value())
                        .build());
    }

    static ResponseEntity<Payload> forbidden(String errorMessage){
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(Payload.builder()
                        .errors(Set.of(new Error(errorMessage)))
                        .status(FAILURE)
                        .code(HttpStatus.FORBIDDEN.value())
                        .build());
    }
}
