package ch.zhaw.pm3.whattowatch.service;

import ch.zhaw.pm3.whattowatch.datasource.MovieDAO;
import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    private final MovieDAO movieDAO;

    @Autowired
    public MovieService(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public List<Movie> getAllMovies() {
        return movieDAO.getMovieList();
    }

    public Optional<Movie> getMovietById(UUID id) {
        return movieDAO.selectClientById(id);
    }

    public boolean addMovie(Movie movie) {
        return movieDAO.insertMovie(movie);
    }
}
