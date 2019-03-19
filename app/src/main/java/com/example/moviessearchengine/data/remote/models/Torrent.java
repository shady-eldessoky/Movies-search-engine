package com.example.moviessearchengine.data.remote.models;

import com.google.gson.annotations.SerializedName;

public class Torrent {

    @SerializedName("url")
    private String url;
    @SerializedName("quality")
    private String quality;
    @SerializedName("size")
    private String size;

    public Torrent(String url, String quality, String size) {
        this.url = url;
        this.quality = quality;
        this.size = size;
    }
    public Torrent() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
