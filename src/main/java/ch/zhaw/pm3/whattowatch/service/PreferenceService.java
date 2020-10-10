package ch.zhaw.pm3.whattowatch.service;

import ch.zhaw.pm3.whattowatch.dao.PreferenceDAO;
import ch.zhaw.pm3.whattowatch.dao.UserDAO;
import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {
    private final PreferenceDAO preferenceDAO;
    private final UserDAO userDAO;

    @Autowired
    public PreferenceService(PreferenceDAO preferenceDAO,
                             UserDAO userDAO) {
        this.preferenceDAO = preferenceDAO;
        this.userDAO = userDAO;
    }

    public int addPreference(int userid, Movie movie) {
        return preferenceDAO.insertPreference(userid, movie);
    }

    public List<Movie> getPreference() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) authentication.getPrincipal();
        System.out.println(authenticatedUser.getUsername());
        System.out.println(authenticatedUser.getPassword());
        System.out.println(userDAO.selectIdByUsername(authenticatedUser.getUsername()));
        int userid = userDAO.selectIdByUsername(authenticatedUser.getUsername());
        return preferenceDAO.getPreferenceList(userid);
    }
}
