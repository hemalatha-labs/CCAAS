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
import com.CCS.Service.Service.CloudAccountService;
import com.CCS.Service.model.CloudAccount;

@RestController
@RequestMapping("/api/cloudaccount")
public class CloudAccountController {

    @Autowired
    private CloudAccountService cloudAccountService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CloudAccount>>> getAllCloudAccounts() {

        List<CloudAccount> cloudAccounts = cloudAccountService.getAllCloudAccount();

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Accounts fetched successfully", cloudAccounts, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<CloudAccount>>> getCloudAccountById(@PathVariable Long id) {

        Optional<CloudAccount> cloudAccount = cloudAccountService.getCloudAccount(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Account fetched successfully", cloudAccount, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CloudAccount>> createCloudAccount(@RequestBody CloudAccount cloudAccount) {

        CloudAccount createdCloudAccount = cloudAccountService.newCloudAccount(cloudAccount);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Account created successfully", createdCloudAccount, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CloudAccount>> updateCloudAccount(
            @PathVariable Long id,
            @RequestBody CloudAccount cloudAccount) {

        CloudAccount updatedCloudAccount = cloudAccountService.UpdateCloudAccount(cloudAccount);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Account updated successfully", updatedCloudAccount, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCloudAccount(@PathVariable Long id) {

        cloudAccountService.deleteCloudAccount(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Cloud Account deleted successfully", null, true));
    }
}