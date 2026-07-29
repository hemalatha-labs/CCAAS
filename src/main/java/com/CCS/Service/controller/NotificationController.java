package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.CCS.Service.Service.NotificationService;
import com.CCS.Service.model.Notification;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Notification>>> getAllNotifications() {

        List<Notification> notifications =
                notificationService.getAllNotifications();

        return ResponseEntity.ok(
                new ApiResponse<>("Notifications fetched successfully",
                        notifications, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Notification>>> getNotificationById(
            @PathVariable Long id) {

        Optional<Notification> notification =
                notificationService.getNotification(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Notification fetched successfully",
                        notification, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Notification>> createNotification(
            @RequestBody Notification notification) {

        Notification createdNotification =
                notificationService.newNotification(notification);

        return ResponseEntity.ok(
                new ApiResponse<>("Notification created successfully",
                        createdNotification, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Notification>> updateNotification(
            @PathVariable Long id,
            @RequestBody Notification notification) {

        Notification updatedNotification =
                notificationService.UpdateNotification(notification);

        return ResponseEntity.ok(
                new ApiResponse<>("Notification updated successfully",
                        updatedNotification, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteNotification(
            @PathVariable Long id) {

        notificationService.deleteNotification(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Notification deleted successfully",
                        null, true));
    }
}