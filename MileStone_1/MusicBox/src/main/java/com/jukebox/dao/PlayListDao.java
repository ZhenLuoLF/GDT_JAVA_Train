package com.jukebox.dao;

import com.jukebox.models.Audio;
import com.jukebox.models.PlayList;

import java.util.ArrayList;
import java.util.List;

public class PlayListDao {
    private List<PlayList> playlists;
    public PlayListDao() { playlists = new ArrayList<>(); }
    public List<PlayList> getPlaylists() {
        return playlists;
    }
    public void setPlaylists(List<PlayList> playlists) {
        this.playlists = playlists;
    }
    public void addPlaylist(PlayList playlist) {
        playlists.add(playlist);
    }
    public void removePlaylist(PlayList playlist) {
        playlists.remove(playlist);
    }
    public PlayList getPlaylistById(int id) {
        PlayList playlist = null;
        for (PlayList pl : playlists) {
            if(pl.getId() == id){
                playlist = pl;
            }
        }
        return playlist;
    }

    public PlayList getPlaylistByTitle(String title) {
        PlayList playlist = null;
        for (PlayList pl : playlists) {
            if(pl.getTitle().equals(title)){
                playlist = pl;
            }
        }
        return playlist;
    }

    public static void printPlaylist(PlayList playlist) {
        for(Audio audio : playlist.getList()){
            System.out.println(audio);
        }

    }

}
