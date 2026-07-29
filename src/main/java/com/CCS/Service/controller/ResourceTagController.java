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
import com.CCS.Service.Service.ResourceTagService;
import com.CCS.Service.model.ResourceTag;

@RestController
@RequestMapping("/api/resourcetag")
public class ResourceTagController {

    @Autowired
    private ResourceTagService resourceTagService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ResourceTag>>> getAllResourceTags() {

        List<ResourceTag> resourceTags = resourceTagService.getAllResourceTags();

        return ResponseEntity.ok(
                new ApiResponse<>("Resource Tags fetched successfully", resourceTags, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ResourceTag>>> getResourceTagById(@PathVariable Long id) {

        Optional<ResourceTag> resourceTag = resourceTagService.getResourceTag(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Resource Tag fetched successfully", resourceTag, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ResourceTag>> createResourceTag(@RequestBody ResourceTag resourceTag) {

        ResourceTag createdResourceTag = resourceTagService.newResourceTag(resourceTag);

        return ResponseEntity.ok(
                new ApiResponse<>("Resource Tag created successfully", createdResourceTag, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ResourceTag>> updateResourceTag(
            @PathVariable Long id,
            @RequestBody ResourceTag resourceTag) {

        ResourceTag updatedResourceTag = resourceTagService.UpdateResourceTag(resourceTag);

        return ResponseEntity.ok(
                new ApiResponse<>("Resource Tag updated successfully", updatedResourceTag, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteResourceTag(@PathVariable Long id) {

        resourceTagService.deleteResourceTag(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Resource Tag deleted successfully", null, true));
    }
}