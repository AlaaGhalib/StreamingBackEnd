package com.example.Streamingservice.DTO;

public class VideoPublicDTO {
    private Long lengthOfVideo;
    private String name;
    private String url;
    public VideoPublicDTO() {

    }
    public VideoPublicDTO(Long lengthOfVideo_, String name_, String url_) {
        this.lengthOfVideo = lengthOfVideo_;
        this.name = name_;
        this.url = url_;
    }

    public Long getLengthOfVideo() {
        return lengthOfVideo;
    }

    public void setLengthOfVideo(Long lengthOfVideo) {
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
