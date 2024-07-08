package com.jukebox.models;


public class Song extends Audio {
    private String artist;
    private String album;
    private String genre;

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Song(int id, String title, String artist, String album, String genre){
        super(id, title);
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }
    @Override
    public String toString(){
        return super.toString() + " - " + artist + " - " + album + " - " + genre;
    }
}
