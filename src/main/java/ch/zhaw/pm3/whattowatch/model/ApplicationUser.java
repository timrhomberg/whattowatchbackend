package ch.zhaw.pm3.whattowatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

public class ApplicationUser extends User {
    private final int userid;

    public ApplicationUser(int userid,
                           @JsonProperty("username") String username,
                           @JsonProperty("password") String password) {
        super(username, password, new ArrayList<>());
        this.userid = userid;
    }

    public ApplicationUser(ApplicationUser applicationUser) {
        super(applicationUser.getUsername(), applicationUser.getPassword(), new ArrayList<>());
        this.userid = applicationUser.getUserid();
    }

    public int getUserid() {
        return userid;
    }
}
