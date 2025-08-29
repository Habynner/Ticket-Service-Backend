package com.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.dtos.TicketRequestDTO;
import com.ticket.model.Status;
import com.ticket.model.Ticket;
import com.ticket.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public Ticket criar(TicketRequestDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(Status.OPEN); // status inicial
        return repository.save(ticket);
    }

    public List<Ticket> listarTodos() {
        return repository.findAll();
    }

    public Optional<Ticket> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Ticket atualizarStatus(String id, Status novoStatus) {
    return repository.findById(id).map(ticket -> {
        ticket.setStatus(novoStatus);
        return repository.save(ticket);
    }).orElseThrow(() -> new RuntimeException("Ticket não encontrado"));
}

    public void deletar(String id) {
        repository.deleteById(id);
    }
}

