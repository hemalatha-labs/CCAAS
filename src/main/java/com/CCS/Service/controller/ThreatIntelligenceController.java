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
import com.CCS.Service.Service.ThreatIntelligenceService;
import com.CCS.Service.model.ThreatIntelligence;

@RestController
@RequestMapping("/api/threatintelligence")
public class ThreatIntelligenceController {

    @Autowired
    private ThreatIntelligenceService threatIntelligenceService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ThreatIntelligence>>> getAllThreatIntelligence() {

        List<ThreatIntelligence> threatIntelligenceList =
                threatIntelligenceService.getAllThreatIntelligences();

        return ResponseEntity.ok(
                new ApiResponse<>("Threat Intelligence fetched successfully",
                        threatIntelligenceList, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ThreatIntelligence>>> getThreatIntelligenceById(
            @PathVariable Long id) {

        Optional<ThreatIntelligence> threatIntelligence =
                threatIntelligenceService.getThreatIntelligence(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Threat Intelligence fetched successfully",
                        threatIntelligence, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ThreatIntelligence>> createThreatIntelligence(
            @RequestBody ThreatIntelligence threatIntelligence) {

        ThreatIntelligence createdThreatIntelligence =
                threatIntelligenceService.newThreatIntelligence(threatIntelligence);

        return ResponseEntity.ok(
                new ApiResponse<>("Threat Intelligence created successfully",
                        createdThreatIntelligence, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ThreatIntelligence>> updateThreatIntelligence(
            @PathVariable Long id,
            @RequestBody ThreatIntelligence threatIntelligence) {

        ThreatIntelligence updatedThreatIntelligence =
                threatIntelligenceService.UpdateThreatIntelligence(threatIntelligence);

        return ResponseEntity.ok(
                new ApiResponse<>("Threat Intelligence updated successfully",
                        updatedThreatIntelligence, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteThreatIntelligence(@PathVariable Long id) {

        threatIntelligenceService.deleteThreatIntelligence(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Threat Intelligence deleted successfully",
                        null, true));
    }
}