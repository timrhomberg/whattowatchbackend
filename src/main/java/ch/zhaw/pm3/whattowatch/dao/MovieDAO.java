package ch.zhaw.pm3.whattowatch.dao;

import ch.zhaw.pm3.whattowatch.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    int insertMovie(Movie movie);

    List<Movie> getMovieList();

    Optional<Movie> selectMovieById(String id);
}
