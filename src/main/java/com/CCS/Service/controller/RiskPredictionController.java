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
import com.CCS.Service.Service.RiskPredictionService;
import com.CCS.Service.model.RiskPrediction;

@RestController
@RequestMapping("/api/riskprediction")
public class RiskPredictionController {

    @Autowired
    private RiskPredictionService riskPredictionService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<RiskPrediction>>> getAllRiskPredictions() {

        List<RiskPrediction> riskPredictions = riskPredictionService.getAllRiskPredictions();

        return ResponseEntity.ok(
                new ApiResponse<>("Risk Predictions fetched successfully", riskPredictions, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<RiskPrediction>>> getRiskPredictionById(@PathVariable Long id) {

        Optional<RiskPrediction> riskPrediction = riskPredictionService.getRiskPrediction(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Risk Prediction fetched successfully", riskPrediction, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RiskPrediction>> createRiskPrediction(
            @RequestBody RiskPrediction riskPrediction) {

        RiskPrediction createdRiskPrediction =
                riskPredictionService.newRiskPrediction(riskPrediction);

        return ResponseEntity.ok(
                new ApiResponse<>("Risk Prediction created successfully", createdRiskPrediction, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RiskPrediction>> updateRiskPrediction(
            @PathVariable Long id,
            @RequestBody RiskPrediction riskPrediction) {

        RiskPrediction updatedRiskPrediction =
                riskPredictionService.UpdateRiskPrediction(riskPrediction);

        return ResponseEntity.ok(
                new ApiResponse<>("Risk Prediction updated successfully", updatedRiskPrediction, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRiskPrediction(@PathVariable Long id) {

        riskPredictionService.deleteRiskPrediction(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Risk Prediction deleted successfully", null, true));
    }
}