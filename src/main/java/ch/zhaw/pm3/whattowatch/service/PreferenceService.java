package ch.zhaw.pm3.whattowatch.service;

import ch.zhaw.pm3.whattowatch.dao.PreferenceDAO;
import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {
    private final PreferenceDAO preferenceDAO;

    @Autowired
    public PreferenceService(PreferenceDAO preferenceDAO) {
        this.preferenceDAO = preferenceDAO;
    }

    public void addPreference(Movie movie) {

    }

    public List<Movie> getPreference(int userid) {
        return preferenceDAO.getPreferenceList(userid);
    }
}
