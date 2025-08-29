package com.ticket.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "TicketRequestDTO", description = "Dados obrigatórios para criação de um ticket")
public class TicketRequestDTO {

    @Schema(description = "Título do ticket", example = "Erro no 100", required = true)
    @NotBlank
    private String title;

    @Schema(description = "Descrição do problema", example = "Usuário não consegue acessar o sistema, pq não lembra a senha", required = true)
    @NotBlank
    private String description;

    // Getters e setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
