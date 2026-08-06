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

	public User() {
		super();
	}

	public User(Long userId, String name, String email, Role role, Boolean status) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.role = role;
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

    
  
}