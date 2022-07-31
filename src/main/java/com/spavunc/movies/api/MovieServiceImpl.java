package com.spavunc.movies.api;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    MovieRepository movieRepository;

    MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public Optional<Movie> findMovieByTitle(String name) {
        return movieRepository.findMovieByTitle(name);
    }

    @Override
    public List<Movie> findMoviesByReleaseDate(LocalDate releaseDate) {
        return movieRepository.findMoviesByDate(releaseDate);
    }

    @Override
    public Movie saveMovie(MovieCommand movieCommand) {
        return movieRepository.save(new Movie(movieCommand.getTitle(), movieCommand.getDate(),
                movieCommand.getRank(), movieCommand.getRevenue()));
    }

    @Override
    public void deleteMovieById(Long id) {
        Optional<Movie> movie = findMovieById(id);
        if(movie.isPresent()){
            movieRepository.deleteById(id);
        }}

    @Override
    public Optional<Movie> editMovieDetails(Long id, MovieCommand movieCommand) {
        Optional<Movie> movieOptional = findMovieById(id);
        if(movieOptional.isPresent()){
            return Optional.ofNullable(movieRepository.save(new Movie(id, movieCommand.getTitle(),
                    movieCommand.getDate(), movieCommand.getRank(), movieCommand.getRevenue())));
        }else{
            return movieOptional;
        }
    }

}
