package ch.zhaw.pm3.whattowatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.UUID;

public class Movie {
    private final String id;
    private final int rank;
    private final String title;
    private final String fullTitle;
    private final String year;
    private final float imdbRating;
    private final int imdbRatingCount;

    public Movie(@JsonProperty("id") String id,
                 @JsonProperty("rank") int rank,
                 @JsonProperty("title") String title,
                 @JsonProperty("fullTitle") String fullTitle,
                 @JsonProperty("year") String year,
                 @JsonProperty("imdbRating") float imdbRating,
                 @JsonProperty("imdbRatingCount") int imdbRatingCount) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.fullTitle = fullTitle;
        this.year = year;
        this.imdbRating = imdbRating;
        this.imdbRatingCount = imdbRatingCount;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
