package ch.zhaw.pm3.whattowatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Movie {
    private final String id;
    private final int rank;
    private final String title;

    public Movie(@JsonProperty("id") String id,
                  @JsonProperty("rank") int rank,
                  @JsonProperty("name") String title) {
        this.id = id;
        this.rank = rank;
        this.title = title;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
