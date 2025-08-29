package com.ticket.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    OPEN,
    IN_PROGRESS,
    CLOSED
}
