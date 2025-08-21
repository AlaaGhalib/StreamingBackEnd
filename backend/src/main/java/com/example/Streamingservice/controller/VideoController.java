package com.example.Streamingservice.controller;

import com.example.Streamingservice.DTO.Mapper.VideoDTOMappers;
import com.example.Streamingservice.DTO.VideoAdminDTO;
import com.example.Streamingservice.DTO.VideoCreateDTO;
import com.example.Streamingservice.DTO.VideoPublicDTO;
import com.example.Streamingservice.DTO.VideoUpdateDTO;
import com.example.Streamingservice.model.Video;
import com.example.Streamingservice.service.VideoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/videos")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
    @GetMapping("/public")
    public List<VideoPublicDTO> getAllVideosPublic() {
        return videoService.getAllVideosPublic();
    }
    @GetMapping("/admin")
    public List<VideoAdminDTO> getAllVideosadmin() {
        return videoService.getAllVideosAdmin();
    }

    @PostMapping("")
    public VideoAdminDTO addVideo(@RequestBody VideoCreateDTO dto) {
        Video video = videoService.addVideo(dto);
        return VideoDTOMappers.toAdminDTO(video);
    }

    @PutMapping("/{id}")
    public VideoAdminDTO videoUpdate(@PathVariable Long id, @RequestBody VideoUpdateDTO dto) {
        Video updated = videoService.updateVideo(id, dto);
        return VideoDTOMappers.toAdminDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void removeVideo(@PathVariable Long id) {
        videoService.removeVideo(id);
    }
}
