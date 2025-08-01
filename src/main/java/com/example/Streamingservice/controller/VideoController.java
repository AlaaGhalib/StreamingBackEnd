package com.example.Streamingservice.controller;

import com.example.Streamingservice.model.Video;
import com.example.Streamingservice.service.VideoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }
    @PostMapping
    public Video addVideo(@RequestBody Video video) {
        return videoService.addVideo(video);
    }
    @DeleteMapping
    public void removeVideo(@RequestBody Video video) {
        videoService.removeVideo(video);
    }
}
