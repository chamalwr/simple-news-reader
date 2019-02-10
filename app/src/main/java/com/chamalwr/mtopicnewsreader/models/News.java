package com.chamalwr.mtopicnewsreader.models;

public class News {

    private String id;
    private String name;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlImage;
    private String publishedAt;
    private String content;

    public News(String id, String name, String author, String title, String description, String url, String urlImage, String publishedAt, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlImage = urlImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
