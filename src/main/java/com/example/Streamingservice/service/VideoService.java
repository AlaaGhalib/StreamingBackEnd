package com.example.Streamingservice.service;

import com.example.Streamingservice.model.Video;
import com.example.Streamingservice.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }
    public void removeVideo(Video video) {
        videoRepository.delete(video);
    }
}
