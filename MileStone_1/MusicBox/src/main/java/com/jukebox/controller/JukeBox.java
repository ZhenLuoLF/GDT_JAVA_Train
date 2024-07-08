package com.jukebox.controller;

import com.jukebox.models.PlayList;
import com.jukebox.models.Podcast;
import com.jukebox.models.Song;
import com.jukebox.service.PlayListService;
import com.jukebox.service.PodcastService;
import com.jukebox.service.SongService;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeBox {
    private static PlayListService playListService = new PlayListService();
    private static PodcastService podcastService = new PodcastService();
    private static SongService songService =  new SongService();

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now();
        date2 = date2.minusMonths(2);

        List<String> celebrities1 = new ArrayList<>();
        celebrities1.add("cel1");
        celebrities1.add("cel2");
        celebrities1.add("cel3");
        celebrities1.add("cel4");

        List<String> celebrities2 = new ArrayList<>();
        celebrities2.add("cel6");
        celebrities2.add("cel7");
        celebrities2.add("cel8");
        celebrities2.add("cel9");
        podcastService.save(new Podcast(0, "podcastTitle1", date1,  celebrities1));
        podcastService.save(new Podcast(1, "podcastTitle2", date2, celebrities2));
        podcastService.save(new Podcast(2, "podcastTitle3", date1, celebrities2));
        podcastService.save(new Podcast(3, "podcastTitle4", date2, celebrities1));

        songService.save(new Song(4,"songTitle1", "artist1", "album1", "genre1"));
        songService.save(new Song(5,"songTitle2", "artist1", "album1", "genre2"));
        songService.save(new Song(6,"songTitle3", "artist2", "album2", "genre1"));
        songService.save(new Song(7,"songTitle4", "artist3", "album3", "genre3"));
        System.out.println("Welcome to JukeBox! Here is the list of available playlists!");
        printSongList(songService.getAllSongs());
        printPodcastList(podcastService.getAllPodcasts());
        while(true) {
            System.out.println("Chose what you want to proceed:");
            System.out.println("1. Search for songs.");
            System.out.println("2. Search for podcasts.");
            System.out.println("3. List and edite my playlists.");
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    searchSong(songService);
                    break;
                case 2:
                    searchPodcast(podcastService);
                    break;
                case 3:
                    playListService.printAll();
                    editePlayLists(playListService, songService, podcastService);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
    public static void editePlayLists(PlayListService playListService, SongService songService, PodcastService podcastService) {
        while(true) {
            playListService.printAll();
            System.out.println("How would you like to edite playlist?");
            System.out.println("1. Add a new playlist.");
            System.out.println("2. Edit a playlist.");
            System.out.println("0. Return to main menu.");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewPlaylist(playListService);
                    break;
                case 2:
                    editePlayList(playListService, songService, podcastService);
                    break;
                case 0:
                    return;
            }
        }
    }
    public static void addToPlayList(SongService songService, PodcastService podcastService, PlayList playList, String content) {
        List<Song> songList = songService.getAllSongs();
        List<Podcast> podcastList = podcastService.getAllPodcasts();

        for (Song song : songList) {
            if (song.getTitle().equals(content) || song.getAlbum().equals(content)) {
                playList.addAudio(song);
            }
        }

        for (Podcast podcast : podcastList) {
            if(podcast.getTitle().equals(content) || podcast.getCelebrities().contains(content)) {
                playList.addAudio(podcast);
            }
        }
    }
    public static void editePlayList(PlayListService playListService, SongService songService, PodcastService podcastService){
        playListService.printAll();
        System.out.println("Please input the title of the playlist you would like to edite.");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        PlayList playlist = playListService.findByTitle(title);
        System.out.println(playlist);
        System.out.println("Please input the songs or album or podcast you would like to add:");
        String addContent = scanner.nextLine();
        addToPlayList(songService, podcastService, playlist, addContent);
    }
    public static void addNewPlaylist(PlayListService playListService) {
        System.out.println("Please input the title of the new playlist.");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        playListService.addNewPlayList(title);
    }
    public static void searchSong(SongService songService){
        System.out.println("How would you like to search?");
        System.out.println("1. Search album");
        System.out.println("2. Search artists");
        System.out.println("3. Search genre");
        System.out.println("0. Return to main menu");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please input the search content:");
        String search = scanner.nextLine();
        System.out.println("Result for " + search + ":");
        switch (choice) {
            case 1:
                songService.searchWithAlbum(search);
                break;
            case 2:
                songService.searchWithArtist(search);
                break;
            case 3:
                songService.searchWithGenre(search);
                break;
            case 0:
                break;
        }
    }
    public static void searchPodcast(PodcastService podcastService){
        System.out.println("How would you like to search?");
        System.out.println("1. Search celebrities");
        System.out.println("2. Search published date");
        System.out.println("0. Return to main menu");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        String input = null;
        switch (choice) {
            case 1:
                System.out.println("Please input the celebrities you wish to search, split them by space:");
                input = scanner.nextLine();
                String[] search  = input.split(" ");
                podcastService.searchWithCelebrities(search);
                break;
            case 2:
                System.out.println("Please input the date you wish to search:");
                input = scanner.nextLine();
                LocalDate searchDate = LocalDate.parse(input);
                podcastService.searchWithPublishedDate(searchDate);
                break;
            case 0:
                break;
        }
    }

    public static void printSongList(List<Song> audioList) {
        for (Song song : audioList) {
            System.out.println(song);
        }
    }
    public static void printPodcastList(List<Podcast> podcastList) {
        for (Podcast podcast : podcastList) {
            System.out.println(podcast);
        }
    }
}
