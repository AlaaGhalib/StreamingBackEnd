package com.example.Streamingservice.DTO;

public class VideoAdminDTO {
    private int lengthOfVideo;
    private String name;
    private String url;
    private Long id;
    public VideoAdminDTO() {

    }
    public VideoAdminDTO(Long id_, int lengthOfVideo_, String name_, String url_) {
        this.id = id_;
        this.lengthOfVideo = lengthOfVideo_;
        this.name = name_;
        this.url = url_;
    }

    public Long getId() {
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
