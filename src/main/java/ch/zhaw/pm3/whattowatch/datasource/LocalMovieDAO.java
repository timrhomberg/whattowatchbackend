package ch.zhaw.pm3.whattowatch.datasource;

import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class LocalMovieDAO implements MovieDAO {
    List<Movie> movieList = new ArrayList<>();

    public LocalMovieDAO() {
        movieList.add(new Movie("test", 0, "rhomberg"));
    }

    public Optional<Movie> selectMovieById(String id) {
        return movieList.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean insertMovie(Movie movie) {
        return movieList.add(movie);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieList;
    }
}
