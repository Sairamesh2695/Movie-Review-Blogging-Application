package com.movie.review_blogging_application.movie.controller;

import com.movie.review_blogging_application.commons.payload.Payload;
import com.movie.review_blogging_application.commons.payload.PayloadBuilder;
import com.movie.review_blogging_application.movie.dto.MovieDTO;
import com.movie.review_blogging_application.movie.dto.MovieUpdateDTO;
import com.movie.review_blogging_application.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Payload> create(@RequestBody MovieDTO movieDTO){
        return PayloadBuilder.created(movieService.create(movieDTO).getId());
    }

    @GetMapping("{id}")
    public ResponseEntity<Payload> getById(@PathVariable long id){
        return PayloadBuilder.ok(movieService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Payload> update(@PathVariable long id, @RequestBody MovieUpdateDTO movieUpdateDTO){
        return PayloadBuilder.updated(movieService.update(id,movieUpdateDTO).getId());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Payload> deleteById(@PathVariable long id){
        return PayloadBuilder.deleted(movieService.delete(id).getId());
    }
}
