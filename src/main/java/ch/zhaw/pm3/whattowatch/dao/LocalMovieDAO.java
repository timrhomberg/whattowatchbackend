package ch.zhaw.pm3.whattowatch.dao;

import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("LocalMovieDB")
public class LocalMovieDAO implements MovieDAO {
    List<Movie> movieList = new ArrayList<>();

    public Optional<Movie> selectMovieById(String id) {
        return movieList.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }

    @Override
    public int insertMovie(Movie movie) {
        return movieList.add(movie) ? 1 : 0;
    }

    @Override
    public List<Movie> getMovieList() {
        return movieList;
    }
}
