package com.ticket.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Dados para criação de um ticket")
@Document(collection = "tickets")
public class Ticket {

    @Id
    private String id;
    @Schema(description = "Título do ticket", example = "Erro no login")
    private String title;
    @Schema(description = "Descrição detalhada", example = "Usuário não consegue acessar o sistema")
    private String description;
    private Status status;
    private LocalDateTime createdAt;

    // Construtor vazio
    public Ticket() {
        this.createdAt = LocalDateTime.now(); // define a data de criação automaticamente
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
