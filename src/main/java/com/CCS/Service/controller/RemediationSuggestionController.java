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
import com.CCS.Service.Service.RemediationSuggestionService;
import com.CCS.Service.model.RemediationSuggestion;

@RestController
@RequestMapping("/api/remediationsuggestion")
public class RemediationSuggestionController {

    @Autowired
    private RemediationSuggestionService remediationSuggestionService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<RemediationSuggestion>>> getAllRemediationSuggestions() {

        List<RemediationSuggestion> remediationSuggestions =
                remediationSuggestionService.getAllRemediationSuggestions();

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Suggestions fetched successfully",
                        remediationSuggestions, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<RemediationSuggestion>>> getRemediationSuggestionById(
            @PathVariable Long id) {

        Optional<RemediationSuggestion> remediationSuggestion =
                remediationSuggestionService.getRemediationSuggestion(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Suggestion fetched successfully",
                        remediationSuggestion, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RemediationSuggestion>> createRemediationSuggestion(
            @RequestBody RemediationSuggestion remediationSuggestion) {

        RemediationSuggestion createdRemediationSuggestion =
                remediationSuggestionService.newRemediationSuggestion(remediationSuggestion);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Suggestion created successfully",
                        createdRemediationSuggestion, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RemediationSuggestion>> updateRemediationSuggestion(
            @PathVariable Long id,
            @RequestBody RemediationSuggestion remediationSuggestion) {

        RemediationSuggestion updatedRemediationSuggestion =
                remediationSuggestionService.UpdateRemediationSuggestion(remediationSuggestion);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Suggestion updated successfully",
                        updatedRemediationSuggestion, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRemediationSuggestion(
            @PathVariable Long id) {

        remediationSuggestionService.deleteRemediationSuggestion(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Suggestion deleted successfully",
                        null, true));
    }
}