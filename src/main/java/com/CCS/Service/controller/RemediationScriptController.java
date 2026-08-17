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
import com.CCS.Service.RequestDTO.RemediationScriptRequestDTO;
import com.CCS.Service.ResponseDTO.RemediationScriptResponseDTO;
import com.CCS.Service.Service.RemediationScriptService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/remediation-scripts")
@RequiredArgsConstructor
public class RemediationScriptController {

    @Autowired
    private RemediationScriptService
            remediationScriptService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<
                List<RemediationScriptResponseDTO>>>
    getAllScripts() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Remediation scripts fetched successfully",
                        remediationScriptService
                                .getAllScripts(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<RemediationScriptResponseDTO>>
    getScript(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Remediation script fetched successfully",
                        remediationScriptService
                                .getScript(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<RemediationScriptResponseDTO>>
    newScript(
            @Valid @RequestBody
            RemediationScriptRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Remediation script created successfully",
                        remediationScriptService
                                .newScript(dto),
                        true),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<RemediationScriptResponseDTO>>
    updateScript(
            @PathVariable UUID id,
            @Valid @RequestBody
            RemediationScriptRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Remediation script updated successfully",
                        remediationScriptService
                                .updateScript(id, dto),
                        true));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteScript(@PathVariable UUID id) {

        remediationScriptService
                .deleteScript(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Remediation script deleted successfully",
                        null,
                        true));
    }
}