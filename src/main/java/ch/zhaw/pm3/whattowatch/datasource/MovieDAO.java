package ch.zhaw.pm3.whattowatch.datasource;

import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MovieDAO {
    List<Movie> movieList = new ArrayList<>();

    public MovieDAO() {
        movieList.add(new Movie(UUID.randomUUID(), "rhomberg"));
    }

    public Optional<Movie> selectClientById(UUID id) {
        return movieList.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public boolean insertMovie(Movie movie) {
        return movieList.add(movie);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
