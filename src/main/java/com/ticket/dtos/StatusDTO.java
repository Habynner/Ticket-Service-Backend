package com.ticket.dtos;

import com.ticket.model.Status;
import jakarta.validation.constraints.NotNull;

public class StatusDTO {

    @NotNull(message = "O status não pode ser nulo")
    private Status status;

    public StatusDTO() {
    }

    public StatusDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
