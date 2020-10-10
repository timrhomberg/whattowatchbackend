package ch.zhaw.pm3.whattowatch.dao;

import ch.zhaw.pm3.whattowatch.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<ApplicationUser> selectUserByUsername(String queryUsername) {
        final String sql = "SELECT id, username, password from \"user\" WHERE username = ?";
        ApplicationUser applicationUser = jdbcTemplate.queryForObject(
                sql,
                new Object[]{queryUsername},
                (resultSet,i) -> {
                    int userid = Integer.parseInt(resultSet.getString("id"));
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    return new ApplicationUser(userid, username, password);
                });
        return Optional.ofNullable(applicationUser);
    }

    public int addUser(String username, String password) {
        final String sql = "INSERT INTO \"user\" (username, password) VALUES(?, ?)";
        return jdbcTemplate.update(
                sql,
                username,
                password
        );
    }

    public int selectIdByUsername(String queryUsername) {
        final String sql = "SELECT id from \"user\" WHERE username = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{queryUsername},
                (resultSet,i) -> {
                    return Integer.parseInt(resultSet.getString("id"));
                });
    }
}
