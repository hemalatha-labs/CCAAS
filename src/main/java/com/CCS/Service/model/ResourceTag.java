package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.TagStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "resource_tag")
@Data
public class ResourceTag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tagId;

    private String tagKey;

    private String tagValue;

    @Enumerated(EnumType.STRING)
    private TagStatus status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "cloud_resource_id")
    private CloudResource cloudResource;
}