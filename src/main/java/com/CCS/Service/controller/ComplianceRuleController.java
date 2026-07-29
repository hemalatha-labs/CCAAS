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
import com.CCS.Service.Service.ComplianceRuleService;
import com.CCS.Service.model.ComplianceRule;

@RestController
@RequestMapping("/api/compliancerule")
public class ComplianceRuleController {

    @Autowired
    private ComplianceRuleService complianceRuleService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ComplianceRule>>> getAllComplianceRules() {

        List<ComplianceRule> rules = complianceRuleService.getAllComplianceRules();

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Rules fetched successfully", rules, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ComplianceRule>>> getComplianceRuleById(@PathVariable Long id) {

        Optional<ComplianceRule> rule = complianceRuleService.getComplianceRule(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Rule fetched successfully", rule, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ComplianceRule>> createComplianceRule(
            @RequestBody ComplianceRule rule) {

        ComplianceRule createdRule = complianceRuleService.newComplianceRule(rule);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Rule created successfully", createdRule, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ComplianceRule>> updateComplianceRule(
            @PathVariable Long id,
            @RequestBody ComplianceRule rule) {

        ComplianceRule updatedRule =
                complianceRuleService.UpdateComplianceRule(rule);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Rule updated successfully", updatedRule, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteComplianceRule(@PathVariable Long id) {

        complianceRuleService.deleteComplianceRule(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Rule deleted successfully", null, true));
    }
}