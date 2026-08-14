package com.CCS.Service.model;

import com.CCS.Service.Enumuration.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    private Long userId;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean status;
  
}