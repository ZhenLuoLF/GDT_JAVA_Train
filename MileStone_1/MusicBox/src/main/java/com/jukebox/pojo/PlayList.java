package com.jukebox.pojo;

import java.util.List;

public class PlayList {
    private int id;
    private List<Audio> list;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Audio> getList() {
        return list;
    }
    public void setList(List<Audio> list) {
        this.list = list;
    }

    public PlayList(int id, List<Audio> list, String title) {
        this.id = id;
        this.list = list;
        this.title = title;
    }
}
