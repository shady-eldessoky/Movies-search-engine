package com.example.moviessearchengine.data.remote.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("id")
    private long id ;
    @SerializedName("url")
    private String url ;
    @SerializedName("title")
    private String title ;
    @SerializedName("title_long")
    private String title_long ;
    @SerializedName("year")
    private long year ;
    @SerializedName("rating")
    private double rating ;
    @SerializedName("genres")
    private List<String> genres ;
    @SerializedName("runtime")
    private int runtime ;
    @SerializedName("summary")
    private String summary ;
    @SerializedName("language")
    private String language ;
    @SerializedName("state")
    private String state ;
    @SerializedName("background_image")
    private String background_image ;
    @SerializedName("small_cover_image")
    private String small_cover_image ;
    @SerializedName("medium_cover_image")
    private String medium_cover_image ;
    @SerializedName("large_cover_image")
    private String large_cover_image ;
    @SerializedName("torrents")
    private List<Torrent> torrents ;

    public Movie(long id, String url,
                 String title, String title_long, long year,
                 double rating, List<String> genres, int runtime, String summary,
                 String language, String state, String background_image, String small_cover_image,
                 String medium_cover_image, String large_cover_image,
                 List<Torrent> torrents) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.title_long = title_long;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.runtime = runtime;
        this.summary = summary;
        this.language = language;
        this.state = state;
        this.background_image = background_image;
        this.small_cover_image = small_cover_image;
        this.medium_cover_image = medium_cover_image;
        this.large_cover_image = large_cover_image;
        this.torrents = torrents;
    }
    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_long() {
        return title_long;
    }

    public void setTitle_long(String title_long) {
        this.title_long = title_long;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public String getSmall_cover_image() {
        return small_cover_image;
    }

    public void setSmall_cover_image(String small_cover_image) {
        this.small_cover_image = small_cover_image;
    }

    public String getMedium_cover_image() {
        return medium_cover_image;
    }

    public void setMedium_cover_image(String medium_cover_image) {
        this.medium_cover_image = medium_cover_image;
    }

    public String getLarge_cover_image() {
        return large_cover_image;
    }

    public void setLarge_cover_image(String large_cover_image) {
        this.large_cover_image = large_cover_image;
    }

    public List<Torrent> getTorrents() {
        return torrents;
    }

    public void setTorrents(List<Torrent> torrents) {
        this.torrents = torrents;
    }
}
