package com.jukebox.service;

import com.jukebox.dao.PodcastDao;
import com.jukebox.models.Podcast;

import java.time.LocalDate;
import java.util.List;

public class PodcastService {
    private PodcastDao podcastDao = new PodcastDao();
    public List<Podcast> getAllPodcasts() {
        return podcastDao.getAllPodcasts();

    }
    public void save(Podcast podcast) {
        podcastDao.save(podcast);
    }

    public void searchWithCelebrities(String[] celebrities){
        for (String celebritie : celebrities) {
            for (Podcast podcast : getAllPodcasts()) {
                if (podcast.getCelebrities().contains(celebritie)) {
                    System.out.println(podcast);
                }
            }
        }
    }

    public void searchWithPublishedDate(LocalDate publishedDate){
        for (Podcast podcast : getAllPodcasts()) {
            if(publishedDate.isEqual(podcast.getPublishedDate())){
                System.out.println(podcast);
            }
        }
    }
}
