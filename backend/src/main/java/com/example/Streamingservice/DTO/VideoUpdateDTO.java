package com.example.Streamingservice.DTO;

public class VideoUpdateDTO {
    private Long id;
    private String name;
    private String url;
    private int lengthOfVideo;

    public VideoUpdateDTO() {}

    public VideoUpdateDTO(Long id, String name, String url, int lengthOfVideo) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.lengthOfVideo = lengthOfVideo;
    }

    public Long getId() {
        return id;
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

