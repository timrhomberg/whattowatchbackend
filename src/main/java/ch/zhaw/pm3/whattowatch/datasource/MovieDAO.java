package ch.zhaw.pm3.whattowatch.datasource;

import ch.zhaw.pm3.whattowatch.model.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieDAO {
    public boolean insertMovie(Movie movie);

    public List<Movie> getMovieList();

    public Optional<Movie> selectMovieById(String id);
}
