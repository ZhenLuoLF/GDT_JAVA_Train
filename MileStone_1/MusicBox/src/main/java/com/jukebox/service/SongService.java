package com.jukebox.service;

import com.jukebox.dao.SongDao;
import com.jukebox.models.Song;

import java.util.List;

public class SongService {
    private SongDao songDao = new SongDao();
    public List<Song> getAllSongs() {
        return songDao.getSongs();
    }
    public void save(Song song) {
        songDao.save(song);
    }

    public void searchWithAlbum(String album){
        for (Song song : songDao.getSongs()) {
            if (song.getAlbum().equals(album)) {
                System.out.println(song);
            }
        }
    }
    public void searchWithGenre(String genre){
        for (Song song : songDao.getSongs()) {
            if (song.getGenre().equals(genre)) {
                System.out.println(song);
            }
        }
    }
    public void searchWithArtist(String artist){
        for (Song song : songDao.getSongs()) {
            if (song.getArtist().equals(artist)) {
                System.out.println(song);
            }
        }
    }

}
