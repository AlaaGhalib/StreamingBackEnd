package com.example.Streamingservice.DTO;

public class VideoCreateDTO {
    private String name;
    private String url;
    private int lengthOfVideo;

    public VideoCreateDTO() {}

    public VideoCreateDTO(String name, String url, int lengthOfVideo) {
        this.name = name;
        this.url = url;
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

    public int getLengthOfVideo() {
        return lengthOfVideo;
    }

    public void setLengthOfVideo(int lengthOfVideo) {
        this.lengthOfVideo = lengthOfVideo;
    }
}
