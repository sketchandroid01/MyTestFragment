package com.sourav.mytestfragment;

import java.io.Serializable;
import java.util.ArrayList;

public class News implements Serializable {

    private String id;
    private String name;
    private ArrayList<NewsItem> newsItemArrayList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<NewsItem> getNewsItemArrayList() {
        return newsItemArrayList;
    }

    public void setNewsItemArrayList(ArrayList<NewsItem> newsItemArrayList) {
        this.newsItemArrayList = newsItemArrayList;
    }
}
