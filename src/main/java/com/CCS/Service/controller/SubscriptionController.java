package com.CCS.Service.controller;

import java.util.List;

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
import com.CCS.Service.RequestDTO.SubscriptionRequestDTO;
import com.CCS.Service.ResponseDTO.SubscriptionResponseDTO;
import com.CCS.Service.Service.SubscriptionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;


    // GET ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<SubscriptionResponseDTO>>>
    getAllSubscriptions() {

        List<SubscriptionResponseDTO> subscriptions =
                subscriptionService.getAllSubscriptions();

        ApiResponse<List<SubscriptionResponseDTO>> response =
                new ApiResponse<>(
                        "Subscriptions fetched successfully",
                        subscriptions,
                        true
                );

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SubscriptionResponseDTO>>
    getSubscription(@PathVariable Long id) {

        SubscriptionResponseDTO subscription =
                subscriptionService.getSubscription(id);

        ApiResponse<SubscriptionResponseDTO> response =
                new ApiResponse<>(
                        "Subscription fetched successfully",
                        subscription,
                        true
                );

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<SubscriptionResponseDTO>>
    newSubscription(
            @Valid @RequestBody SubscriptionRequestDTO dto) {

        SubscriptionResponseDTO subscription =
                subscriptionService.newSubscription(dto);

        ApiResponse<SubscriptionResponseDTO> response =
                new ApiResponse<>(
                        "Subscription created successfully",
                        subscription,
                        true
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SubscriptionResponseDTO>>
    updateSubscription(
            @PathVariable Long id,
            @Valid @RequestBody SubscriptionRequestDTO dto) {

        SubscriptionResponseDTO subscription =
                subscriptionService.updateSubscription(id, dto);

        ApiResponse<SubscriptionResponseDTO> response =
                new ApiResponse<>(
                        "Subscription updated successfully",
                        subscription,
                        true
                );

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteSubscription(@PathVariable Long id) {

        subscriptionService.deleteSubscription(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Subscription deleted successfully",
                        null,
                        true
                );

        return ResponseEntity.ok(response);
    }
}