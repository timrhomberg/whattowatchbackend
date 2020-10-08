package ch.zhaw.pm3.whattowatch.service;

import ch.zhaw.pm3.whattowatch.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlgorithmService {
    public List<Movie> getSpecificRecommendations(int count) {
        List<Movie> recommendationList = new ArrayList<>();
        recommendationList.add(new Movie("1", 1, "Avengers", "ave", "2019", 9.90f, 100));
        return recommendationList;
    }

    public void addPreference(Movie movie) {
        
    }
}
