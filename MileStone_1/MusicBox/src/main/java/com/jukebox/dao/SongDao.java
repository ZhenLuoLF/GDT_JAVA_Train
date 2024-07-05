package com.jukebox.dao;

import com.jukebox.pojo.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SongDao {
    private List<Song> songs = new ArrayList<>();

    public List<Song> getSongs() {
        return songs;
    }
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }
    public boolean removeSong(Song song) {
        return songs.remove(song);
    }

    public Song getSongById(int id) {
        Song song = null;
        for (Song s : songs) {
            if (s.getId() == id){
                song = s;
            }
        }
        return song;
    }
    public Song getSongByTitle(String title) {
        Song song = null;
        for (Song s : songs) {
            if (s.getTitle().equals(title)){
                song = s;
            }
        }
        return song;
    }
}
