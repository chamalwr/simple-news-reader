package com.chamalwr.mtopicnewsreader.functions;

import com.chamalwr.mtopicnewsreader.models.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ApiClient {
    
    List<News> list = new ArrayList<>();
    Map<String, String> newsList;

    public Map<String, String> getNewsList() {
        return newsList;
    }

    public Map<String, String> getNewsArticals(List<News> newsList){

        Map<String, String> articals = new HashMap<>();
        for (News news : newsList){
            articals.put("source_id", news.getSource().getId());
            articals.put("source_name", news.getSource().getName());
            articals.put("author", news.getAuthor());
            articals.put("title", news.getTitle());
            articals.put("description", news.getDescription());
            articals.put("url", news.getUrl());
            articals.put("urlToImage", news.getUrlImage());
            articals.put("published_at", news.getPublishedAt());
            articals.put("content", news.getContent());
        }
        return articals;
    }
}
