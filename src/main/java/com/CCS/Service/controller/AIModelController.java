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
import com.CCS.Service.RequestDTO.AIModelRequestDTO;
import com.CCS.Service.ResponseDTO.AIModelResponseDTO;
import com.CCS.Service.Service.AIModelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ai-models")
@RequiredArgsConstructor
public class AIModelController {

    @Autowired
    private AIModelService aiModelService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<AIModelResponseDTO>>>
    getAllModels() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI models fetched successfully",
                        aiModelService.getAllModels(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<AIModelResponseDTO>>
    getModel(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI model fetched successfully",
                        aiModelService.getModel(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<AIModelResponseDTO>>
    newModel(
            @Valid @RequestBody
            AIModelRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "AI model created successfully",
                        aiModelService.newModel(dto),
                        true),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<AIModelResponseDTO>>
    updateModel(
            @PathVariable UUID id,
            @Valid @RequestBody
            AIModelRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI model updated successfully",
                        aiModelService.updateModel(id, dto),
                        true));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteModel(@PathVariable UUID id) {

        aiModelService.deleteModel(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI model deleted successfully",
                        null,
                        true));
    }
}