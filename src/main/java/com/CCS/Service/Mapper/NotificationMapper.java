package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.NotificationRequestDTO;
import com.CCS.Service.ResponseDTO.NotificationResponseDTO;
import com.CCS.Service.model.Notification;

@Component
public class NotificationMapper {

    public Notification toEntity(
            NotificationRequestDTO dto) {

        Notification notification =
                new Notification();

        notification.setTitle(
                dto.getTitle());

        notification.setMessage(
                dto.getMessage());

        notification.setType(
                dto.getType());

        notification.setIsRead(false);

        notification.setCreatedAt(
                LocalDateTime.now());

        return notification;
    }


    public NotificationResponseDTO toResponseDTO(
            Notification notification) {

        NotificationResponseDTO dto =
                new NotificationResponseDTO();

        dto.setNotificationId(
                notification.getNotificationId());

        dto.setTitle(
                notification.getTitle());

        dto.setMessage(
                notification.getMessage());

        dto.setType(
                notification.getType());

        dto.setIsRead(
                notification.getIsRead());

        dto.setCreatedAt(
                notification.getCreatedAt());

        return dto;
    }
}