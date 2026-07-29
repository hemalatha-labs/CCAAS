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
import com.CCS.Service.Service.AIModelService;
import com.CCS.Service.model.AIModel;

@RestController
@RequestMapping("/api/aimodel")
public class AIModelController {

    @Autowired
    private AIModelService aiModelService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<AIModel>>> getAllAIModels() {

        List<AIModel> aiModels = aiModelService.getAllAIModel();

        return ResponseEntity.ok(
                new ApiResponse<>("AI Models fetched successfully", aiModels, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<AIModel>>> getAIModelById(@PathVariable Long id) {

        Optional<AIModel> aiModel = aiModelService.getAIModel(id);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Model fetched successfully", aiModel, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AIModel>> createAIModel(
            @RequestBody AIModel aiModel) {

        AIModel createdAIModel = aiModelService.newAIModel(aiModel);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Model created successfully", createdAIModel, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AIModel>> updateAIModel(
            @PathVariable Long id,
            @RequestBody AIModel aiModel) {

        AIModel updatedAIModel = aiModelService.UpdateAIModel(aiModel);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Model updated successfully", updatedAIModel, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAIModel(@PathVariable Long id) {

        aiModelService.deleteAIModel(id);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Model deleted successfully", null, true));
    }
}