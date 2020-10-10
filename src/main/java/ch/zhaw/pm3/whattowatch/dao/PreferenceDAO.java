package ch.zhaw.pm3.whattowatch.dao;

import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PreferenceDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PreferenceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getPreferenceList(int userid) {
        final String sql = "SELECT m.id, m.rank, m.title, m.\"fullTitle\", m.year, m.\"imdbRating\", m.\"imdbRatingCount\"\n" +
                "    FROM movie m\n" +
                "    INNER JOIN preference p on m.id = p.movieid\n" +
                "    INNER JOIN user u on p.userid = ?";
        return jdbcTemplate.query(
                sql,
                new Object[]{userid},
                (resultSet,i) -> {
                    String id = resultSet.getString("id");
                    int rank = resultSet.getInt("rank");
                    String title = resultSet.getString("title");
                    String fullTitle = resultSet.getString("fullTitle");
                    String year = resultSet.getString("year");
                    float imdbRating = resultSet.getFloat("imdbRating");
                    int imdbRatingCount = resultSet.getInt("imdbRatingCount");
                    return new Movie(id, rank, title, fullTitle, year, imdbRating, imdbRatingCount);
                }
        );
    }

    /**
     *
     * @param userid
     * @param movie
     * @return Returns the count of effected rows.
     */
    public int insertPreference(int userid, Movie movie) {
        String sql = "INSERT INTO preference (userid, movieid) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                userid,
                movie.getId()
        );
    }
}
