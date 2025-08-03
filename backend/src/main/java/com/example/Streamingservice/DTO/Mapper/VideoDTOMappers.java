package com.example.Streamingservice.DTO.Mapper;

import com.example.Streamingservice.DTO.VideoAdminDTO;
import com.example.Streamingservice.DTO.VideoPublicDTO;
import com.example.Streamingservice.model.Video;

public class VideoDTOMappers {
    public static VideoPublicDTO toPublicDTO(Video video) {
        return new VideoPublicDTO(video.getLengthOfVideo(), video.getName(), video.getUrl());
    }

    public static VideoAdminDTO toAdminDTO(Video video) {
        return new VideoAdminDTO(
                video.getId(),
                video.getLengthOfVideo(),
                video.getName(),
                video.getUrl()
        );
    }
}
