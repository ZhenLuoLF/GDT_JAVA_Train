package com.jukebox.models;

import java.time.LocalDate;
import java.util.List;

public class Podcast extends Audio{
    private List<String> celebrities;
    private LocalDate publishedDate;
    private int id;

    public List<String> getCelebrities() {
        return celebrities;
    }
    public void setCelebrities(List<String> celebrities) {
        this.celebrities = celebrities;
    }
    public LocalDate getPublishedDate() {
        return publishedDate;
    }
    public void setPublisheddate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Podcast(int id, String title, LocalDate publishedDate, List<String> celebrities) {
        super(id, title);
        this.publishedDate = publishedDate;
        this.celebrities = celebrities;
    }

    @Override
    public String toString() {
        return super.toString() + " " + celebrities + " " + publishedDate;
    }
}
