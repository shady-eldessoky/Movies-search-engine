package com.example.moviessearchengine.data.remote.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("movie_count")
    private long movie_count;
    @SerializedName("limit")
    private long limit;
    @SerializedName("movie_count")
    private long page_number;
    @SerializedName("movies")
    private List<Movie> movies;

    public Data(long movie_count, long limit, long page_number, List<Movie> movies) {
        this.movie_count = movie_count;
        this.limit = limit;
        this.page_number = page_number;
        this.movies = movies;
    }
    public Data() {
    }

    public long getMovie_count() {
        return movie_count;
    }

    public void setMovie_count(long movie_count) {
        this.movie_count = movie_count;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getPage_number() {
        return page_number;
    }

    public void setPage_number(long page_number) {
        this.page_number = page_number;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
