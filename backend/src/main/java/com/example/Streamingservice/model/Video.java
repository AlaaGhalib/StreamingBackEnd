package com.example.Streamingservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int lengthOfVideo;
    private String name;
    private String url;
    public Video() {
    }
    public Video(int lengthOfVideo_, String name_, String url_) {
        this.lengthOfVideo = lengthOfVideo_;
        this.name = name_;
        this.url = url_;
    }

    public Long getId() {
        System.out.println(id);
        return id;
    }

    public int getLengthOfVideo() {
        return lengthOfVideo;
    }

    public void setLengthOfVideo(int lengthOfVideo) {
        this.lengthOfVideo = lengthOfVideo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
