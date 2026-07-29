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
import com.CCS.Service.Service.ComplianceFrameworkService;
import com.CCS.Service.model.ComplianceFramework;

@RestController
@RequestMapping("/api/complianceframework")
public class ComplianceFrameworkController {

    @Autowired
    private ComplianceFrameworkService complianceFrameworkService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ComplianceFramework>>> getAllComplianceFrameworks() {

        List<ComplianceFramework> frameworks = complianceFrameworkService.getAllComplianceFrameworks();

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Frameworks fetched successfully", frameworks, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ComplianceFramework>>> getComplianceFrameworkById(@PathVariable Long id) {

        Optional<ComplianceFramework> framework = complianceFrameworkService.getComplianceFramework(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Framework fetched successfully", framework, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ComplianceFramework>> createComplianceFramework(
            @RequestBody ComplianceFramework framework) {

        ComplianceFramework createdFramework = complianceFrameworkService.newComplianceFramework(framework);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Framework created successfully", createdFramework, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ComplianceFramework>> updateComplianceFramework(
            @PathVariable Long id,
            @RequestBody ComplianceFramework framework) {

        ComplianceFramework updatedFramework =
                complianceFrameworkService.newComplianceFramework(framework);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Framework updated successfully", updatedFramework, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteComplianceFramework(@PathVariable Long id) {

        complianceFrameworkService.deleteComplianceFramework(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Framework deleted successfully", null, true));
    }
}