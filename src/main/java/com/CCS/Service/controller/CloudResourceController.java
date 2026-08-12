package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
import com.CCS.Service.Service.CloudResourceService;
import com.CCS.Service.model.CloudResource;

@RestController
@RequestMapping("/api/cloudresource")
public class CloudResourceController {

    @Autowired
    private CloudResourceService cloudResourceService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CloudResource>>> getAllCloudResources() {

        List<CloudResource> cloudResources = cloudResourceService.getAllCloudResources();

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Resources fetched successfully", cloudResources, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<CloudResource>>> getCloudResourceById(@PathVariable UUID id) {

        Optional<CloudResource> cloudResource = cloudResourceService.getCloudResource(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Resource fetched successfully", cloudResource, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CloudResource>> createCloudResource(@RequestBody CloudResource cloudResource) {

        CloudResource createdCloudResource = cloudResourceService.newCloudResource(cloudResource);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Resource created successfully", createdCloudResource, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CloudResource>> updateCloudResource(
            @PathVariable Long id,
            @RequestBody CloudResource cloudResource) {

        CloudResource updatedCloudResource = cloudResourceService.UpdateCloudResource(cloudResource);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Resource updated successfully", updatedCloudResource, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCloudResource(@PathVariable UUID id) {

        cloudResourceService.deleteCloudResource(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Resource deleted successfully", null, true));
    }
}