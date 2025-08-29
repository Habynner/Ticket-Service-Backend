package com.ticket.controller;

import com.ticket.dtos.StatusDTO;
import com.ticket.model.Ticket;
import com.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService service;

    // Criar novo ticket
    @PostMapping
    public ResponseEntity<Ticket> criar(@RequestBody Ticket ticket) {
        Ticket criado = service.criar(ticket);
        return ResponseEntity.ok(criado);
    }

    // Listar todos os tickets
    @GetMapping
    public ResponseEntity<List<Ticket>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // Buscar ticket por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar apenas o status
    @PatchMapping("/{id}/status")
    public ResponseEntity<Ticket> atualizarStatus(@PathVariable String id, @RequestBody StatusDTO dto) {
    Ticket atualizado = service.atualizarStatus(id, dto.getStatus());
    return ResponseEntity.ok(atualizado);
}

    // Deletar ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
