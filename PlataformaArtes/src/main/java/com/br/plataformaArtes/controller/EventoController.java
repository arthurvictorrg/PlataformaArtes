package com.br.comunidadeArteCultura.controller;

import com.br.comunidadeArteCultura.entity.Evento;
import com.br.comunidadeArteCultura.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {
        Evento eventoCreated = service.create(evento);
        return ResponseEntity.status(201).body(eventoCreated);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Evento> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Evento> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/evento-lista-artistas/{id}")
    public List<Artista> eventoListaArtistas(@PathVariable Long id) {
        // Implemente a lógica para buscar e retornar a lista de artistas associados ao evento.
        return service.buscarListaArtistas(id);
    }

    // Adicione outros endpoints conforme necessário para suportar a Comunidade de Arte e Cultura.
}
