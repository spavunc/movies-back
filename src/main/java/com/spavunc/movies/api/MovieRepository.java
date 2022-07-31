package com.spavunc.movies.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieById(Long id);
    Optional<Movie> findMovieByTitle(String name);
    List<Movie> findMoviesByDate(LocalDate releaseDate);
    Movie save(Movie movie);
}
