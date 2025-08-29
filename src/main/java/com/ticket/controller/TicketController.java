package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.dtos.StatusDTO;
import com.ticket.dtos.TicketRequestDTO;
import com.ticket.model.Ticket;
import com.ticket.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService service;

    @Operation(summary = "Criar um novo ticket", description = "Cria um ticket com título, descrição e status.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ticket criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<Ticket> criar(@RequestBody TicketRequestDTO dto) {
        Ticket criado = service.criar(dto);
        return ResponseEntity.ok(criado);
    }

    @Operation(summary = "Listar todos os tickets", description = "Retorna uma lista com todos os tickets cadastrados.")
    @GetMapping
    public ResponseEntity<List<Ticket>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Buscar ticket por ID", description = "Retorna os dados de um ticket específico.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ticket encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))),
        @ApiResponse(responseCode = "404", description = "Ticket não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> buscarPorId(
        @Parameter(description = "ID do ticket a ser buscado") @PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualizar status do ticket", description = "Atualiza apenas o status de um ticket existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))),
        @ApiResponse(responseCode = "404", description = "Ticket não encontrado")
    })
    @PatchMapping("/{id}/status")
    public ResponseEntity<Ticket> atualizarStatus(
        @Parameter(description = "ID do ticket") @PathVariable String id,
        @RequestBody StatusDTO dto) {
        Ticket atualizado = service.atualizarStatus(id, dto.getStatus());
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Deletar ticket", description = "Remove um ticket do sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Ticket deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ticket não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
        @Parameter(description = "ID do ticket a ser deletado") @PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
