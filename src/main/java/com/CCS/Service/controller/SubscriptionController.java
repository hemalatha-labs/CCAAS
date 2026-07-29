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
import com.CCS.Service.Service.SubscriptionService;
import com.CCS.Service.model.Subscription;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Subscription>>> getAllSubscriptions() {

        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();

        return ResponseEntity.ok(
                new ApiResponse<>("Subscriptions fetched successfully", subscriptions, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Subscription>>> getSubscriptionById(@PathVariable Long id) {

        Optional<Subscription> subscription = subscriptionService.getSubscription(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Subscription fetched successfully", subscription, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Subscription>> createSubscription(@RequestBody Subscription subscription) {

        Subscription createdSubscription = subscriptionService.newSubscription(subscription);

        return ResponseEntity.ok(
                new ApiResponse<>("Subscription created successfully", createdSubscription, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Subscription>> updateSubscription(
            @PathVariable Long id,
            @RequestBody Subscription subscription) {

        Subscription updatedSubscription = subscriptionService.UpdateSubscription(subscription);

        return ResponseEntity.ok(
                new ApiResponse<>("Subscription updated successfully", updatedSubscription, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSubscription(@PathVariable Long id) {

        subscriptionService.deletesubscription(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Subscription deleted successfully", null, true));
    }
}