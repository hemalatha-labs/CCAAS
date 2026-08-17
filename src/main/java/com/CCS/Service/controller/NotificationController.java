package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.NotificationRequestDTO;
import com.CCS.Service.ResponseDTO.NotificationResponseDTO;
import com.CCS.Service.Service.NotificationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<NotificationResponseDTO>>>
    getAllNotifications() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Notifications fetched successfully",
                        notificationService
                                .getAllNotifications(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<NotificationResponseDTO>>
    getNotification(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Notification fetched successfully",
                        notificationService
                                .getNotification(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<NotificationResponseDTO>>
    newNotification(
            @Valid @RequestBody
            NotificationRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Notification created successfully",
                        notificationService
                                .newNotification(dto),
                        true),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}/read")
    public ResponseEntity<
            ApiResponse<NotificationResponseDTO>>
    markAsRead(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Notification marked as read",
                        notificationService
                                .markAsRead(id),
                        true));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteNotification(
            @PathVariable UUID id) {

        notificationService
                .deleteNotification(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Notification deleted successfully",
                        null,
                        true));
    }
}