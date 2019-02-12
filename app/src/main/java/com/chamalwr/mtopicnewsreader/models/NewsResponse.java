package com.chamalwr.mtopicnewsreader.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NewsResponse implements Serializable {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<News> newsArticles = null;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<News> getNewsArticles() {
        return newsArticles;
    }

    public void setNewsArticals(List<News> newsArticals) {
        this.newsArticles = newsArticles;
    }
}
