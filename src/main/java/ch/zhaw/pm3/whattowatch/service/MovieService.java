package ch.zhaw.pm3.whattowatch.service;

import ch.zhaw.pm3.whattowatch.dao.MovieDAO;
import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieDAO movieDAO;

    @Autowired
    public MovieService(@Qualifier("PostgresMovieDB") MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public List<Movie> getAllMovies() {
        return movieDAO.getMovieList();
    }

    public Optional<Movie> getMovieById(String id) {
        return movieDAO.selectMovieById(id);
    }

    public int addMovie(Movie movie) {
        return movieDAO.insertMovie(movie);
    }
}
