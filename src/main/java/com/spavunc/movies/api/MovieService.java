package com.spavunc.movies.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<Movie> findMovieById(Long id);
    Optional<Movie> findMovieByTitle(String name);
    List<Movie> findMoviesByReleaseDate(LocalDate releaseDate);
    Movie saveMovie(MovieCommand movieCommand);
    void deleteMovieById(Long id);
    Optional<Movie> editMovieDetails(Long id, MovieCommand movieCommand);
}
