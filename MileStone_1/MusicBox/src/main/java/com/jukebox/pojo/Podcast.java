package com.jukebox.pojo;

import java.time.Instant;
import java.util.List;

public class Podcast extends Audio{
    private List<String> celebrities;
    private Instant publishedTime;
    private int id;

    public List<String> getCelebrities() {
        return celebrities;
    }
    public void setCelebrities(List<String> celebrities) {
        this.celebrities = celebrities;
    }
    public Instant getPublishedTime() {
        return publishedTime;
    }
    public void setPublishedTime(Instant publishedTime) {
        this.publishedTime = publishedTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Podcast(String title, int id) {
        this.id = id;
        super.setTitle(title);
    }
}
