package com.jukebox.service;

import com.jukebox.dao.PlayListDao;
import com.jukebox.models.Audio;
import com.jukebox.models.PlayList;

import java.util.ArrayList;
import java.util.List;

public class PlayListService {
    int currentId = 0;
    private PlayListDao playListDao = new PlayListDao();
    public void addNewPlayList(String title) {
        PlayList playList = new PlayList(++currentId,new ArrayList<Audio>(), title);
        playListDao.addPlaylist(playList);
    }
    public PlayList findByTitle(String title) {
        return playListDao.getPlaylistByTitle(title);
    }
    public void printAll(){
        List<PlayList> playLists = playListDao.getPlaylists();

        for (PlayList playList : playLists) {
            System.out.println(playList);
            PlayListDao.printPlaylist(playList);
        }
    }
}
