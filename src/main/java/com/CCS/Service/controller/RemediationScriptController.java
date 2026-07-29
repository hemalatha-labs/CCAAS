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
import com.CCS.Service.Service.RemediationScriptService;
import com.CCS.Service.model.RemediationScript;

@RestController
@RequestMapping("/api/remediationscript")
public class RemediationScriptController {

    @Autowired
    private RemediationScriptService remediationScriptService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<RemediationScript>>> getAllRemediationScripts() {

        List<RemediationScript> remediationScripts =
                remediationScriptService.getAllRemediationScripts();

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Scripts fetched successfully",
                        remediationScripts, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<RemediationScript>>> getRemediationScriptById(
            @PathVariable Long id) {

        Optional<RemediationScript> remediationScript =
                remediationScriptService.getRemediationScript(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Script fetched successfully",
                        remediationScript, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RemediationScript>> createRemediationScript(
            @RequestBody RemediationScript remediationScript) {

        RemediationScript createdRemediationScript =
                remediationScriptService.newRemediationScript(remediationScript);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Script created successfully",
                        createdRemediationScript, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RemediationScript>> updateRemediationScript(
            @PathVariable Long id,
            @RequestBody RemediationScript remediationScript) {

        RemediationScript updatedRemediationScript =
                remediationScriptService.UpdateRemediationScript(remediationScript);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Script updated successfully",
                        updatedRemediationScript, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRemediationScript(
            @PathVariable Long id) {

        remediationScriptService.deleteRemediationScript(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Remediation Script deleted successfully",
                        null, true));
    }
}