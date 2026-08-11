package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="AIChatSession")
@Data
public class AIChatSession {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID chatId;
	private String question;
	private String answer;
	private LocalDateTime Timestamp;

}
