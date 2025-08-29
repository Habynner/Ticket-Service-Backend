package com.ticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ticket.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {}

