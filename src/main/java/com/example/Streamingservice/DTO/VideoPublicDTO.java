package com.example.Streamingservice.DTO;

public class VideoPublicDTO {
    private int lengthOfVideo;
    private String name;
    private String url;
    public VideoPublicDTO() {

    }
    public VideoPublicDTO(int lengthOfVideo_, String name_, String url_) {
        this.lengthOfVideo = lengthOfVideo_;
        this.name = name_;
        this.url = url_;
    }

    public int getLengthOfVideo() {
        return lengthOfVideo;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
