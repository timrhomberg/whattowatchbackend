package ch.zhaw.pm3.whattowatch.api;

import ch.zhaw.pm3.whattowatch.model.Movie;
import ch.zhaw.pm3.whattowatch.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/movie")
@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(path = "{id}")
    public Movie getSpecificMovie(@PathVariable("id") String id) {
        return movieService.getMovieById(id)
                .orElse(null);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }
}
