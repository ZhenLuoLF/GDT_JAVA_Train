package com.jukebox.controller;

import com.jukebox.service.PlayListService;
import com.jukebox.service.PodcastService;
import com.jukebox.service.SongService;

public class JukeBox {
    private PlayListService playListService = new PlayListService();
    private PodcastService podcastService = new PodcastService();
    private SongService songService =  new SongService();

    public static void main(String[] args) {
        System.out.println("Welcome to JukeBox! Here is the list of available playlists!");
        System.out.println();

    }
}
