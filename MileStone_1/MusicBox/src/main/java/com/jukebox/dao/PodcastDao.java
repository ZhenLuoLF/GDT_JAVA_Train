package com.jukebox.dao;

import com.jukebox.models.Podcast;

import java.util.List;
import java.util.ArrayList;

public class PodcastDao {
    private List<Podcast> podcastList;

    public PodcastDao() {
        podcastList = new ArrayList<>();
    }
    public void add(Podcast podcast) {
        podcastList.add(podcast);
    }
    public List<Podcast> getPodcastList() {
        return podcastList;
    }
    public void setPodcastList(List<Podcast> podcastList) {
        this.podcastList = podcastList;
    }

    public Podcast getPodcast(int id) {
        Podcast podcast = null;
        for (Podcast p : podcastList) {
            if (p.getId() == id) {
                podcast = p;
            }
        }
        return podcast;
    }
    public Podcast getPodcastByCelebrity(String celebrity) {
        Podcast podcast = null;
        for (Podcast p : podcastList) {
            if(p.getCelebrities().contains(celebrity)){
                podcast = p;
            }
        }
        return podcast;
    }
    public List<Podcast> getAllPodcasts() {
        return podcastList;
    }

    public void save(Podcast podcast) {
        podcastList.add(podcast);
    }

}
