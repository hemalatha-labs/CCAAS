package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.NotificationMapper;
import com.CCS.Service.Repo.NotificationRepo;
import com.CCS.Service.RequestDTO.NotificationRequestDTO;
import com.CCS.Service.ResponseDTO.NotificationResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.Notification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private NotificationMapper notificationMapper;


    // GET ALL
    public List<NotificationResponseDTO>
    getAllNotifications() {

        return notificationRepo.findAll()
                .stream()
                .map(notificationMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public NotificationResponseDTO
    getNotification(UUID id) {

        Notification notification =
                notificationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Notification not found with id: "
                                                + id));

        return notificationMapper
                .toResponseDTO(notification);
    }


    // CREATE
    public NotificationResponseDTO
    newNotification(
            NotificationRequestDTO dto) {

        Notification notification =
                notificationMapper.toEntity(dto);

        Notification saved =
                notificationRepo.save(notification);

        return notificationMapper
                .toResponseDTO(saved);
    }


    // MARK AS READ
    public NotificationResponseDTO
    markAsRead(UUID id) {

        Notification notification =
                notificationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Notification not found with id: "
                                                + id));

        notification.setIsRead(true);

        Notification updated =
                notificationRepo.save(notification);

        return notificationMapper
                .toResponseDTO(updated);
    }


    // DELETE
    public void deleteNotification(UUID id) {

        Notification notification =
                notificationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Notification not found with id: "
                                                + id));

        notificationRepo.delete(notification);
    }
}