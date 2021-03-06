package ch.zhaw.pm3.whattowatch.dao;

import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("PostgresMovieDB")
public class MovieDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertMovie(Movie movie) {
        String sql = "INSERT INTO movie (id, title, familyname) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                movie.getId(),
                movie.getTitle()
        );
    }

    public List<Movie> getMovieList() {
        final String sql = "SELECT id, rank, title, \"fullTitle\", year, \"imdbRating\", \"imdbRatingCount\" from movie";
        return jdbcTemplate.query(sql, (resultSet,i) -> {
            String id = resultSet.getString("id");
            int rank = resultSet.getInt("rank");
            String title = resultSet.getString("title");
            String fullTitle = resultSet.getString("fullTitle");
            String year = resultSet.getString("year");
            float imdbRating = resultSet.getFloat("imdbRating");
            int imdbRatingCount = resultSet.getInt("imdbRatingCount");
            return new Movie(id, rank, title, fullTitle, year, imdbRating, imdbRatingCount);
        });
    }

    public Optional<Movie> selectMovieById(String id) {
        return Optional.empty();
    }
}
