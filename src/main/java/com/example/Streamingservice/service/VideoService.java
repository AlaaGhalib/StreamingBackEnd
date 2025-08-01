package com.example.Streamingservice.service;

import com.example.Streamingservice.DTO.Mapper.VideoDTOMappers;
import com.example.Streamingservice.DTO.VideoAdminDTO;
import com.example.Streamingservice.DTO.VideoCreateDTO;
import com.example.Streamingservice.DTO.VideoPublicDTO;
import com.example.Streamingservice.DTO.VideoUpdateDTO;
import com.example.Streamingservice.model.Video;
import com.example.Streamingservice.repository.VideoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<VideoPublicDTO> getAllVideosPublic() {
        return videoRepository.findAll()
                .stream()
                .map(VideoDTOMappers::toPublicDTO)
                .collect(Collectors.toList());
    }
    public List<VideoAdminDTO> getAllVideosAdmin() {
        return videoRepository.findAll()
                .stream()
                .map(VideoDTOMappers::toAdminDTO)
                .collect(Collectors.toList());
    }
    public Video addVideo(VideoCreateDTO DTO) {
        Video video = new Video();
        video.setName(DTO.getName());
        video.setUrl(DTO.getUrl());
        video.setLengthOfVideo(DTO.getLengthOfVideo());
        return videoRepository.save(video);
    }
    public Video updateVideo(Long id, VideoUpdateDTO dto) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Video not found"));
        // update fields
        video.setName(dto.getName());
        video.setUrl(dto.getUrl());
        video.setLengthOfVideo(dto.getLengthOfVideo());
        return videoRepository.save(video);
    }

    public void removeVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
