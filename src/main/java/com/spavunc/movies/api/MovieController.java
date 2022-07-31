package com.spavunc.movies.api;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    MovieServiceImpl movieService;

    MovieController(MovieServiceImpl movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Optional<Movie> movie = movieService.findMovieById(id);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title){
        Optional<Movie> movie = movieService.findMovieByTitle(title);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/onDate")
    public ResponseEntity<List<Movie>> getMoviesByReleaseDate(@RequestParam
          @DateTimeFormat(pattern = "dd.MM.yyyy.") LocalDate date){
        List<Movie> movies = movieService.findMoviesByReleaseDate(date);
        if(!movies.isEmpty()){
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> save(@Valid @RequestBody final MovieCommand movieCommand) {
        Movie movie = movieService.saveMovie(movieCommand);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> editMovieById(@PathVariable Long id,
                                               @Valid @RequestBody final MovieCommand movieCommand){
        Optional<Movie> movie = movieService.editMovieDetails(id, movieCommand);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
