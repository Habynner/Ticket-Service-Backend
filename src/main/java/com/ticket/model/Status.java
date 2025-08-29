package com.ticket.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Status do ticket")
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    OPEN,
    IN_PROGRESS,
    CLOSED
}
