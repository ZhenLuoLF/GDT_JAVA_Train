package com.jukebox.models;



public abstract class Audio {
    private int id;
    private String title;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Audio(int id, String title) {
        this.id = id;
        this.title = title;
    }
    @Override
    public String toString() {
        return title;
    }
}
