package com.br.comunidadeArteCultura.controller;

import com.br.comunidadeArteCultura.entity.ObraArte;
import com.br.comunidadeArteCultura.service.ObraArteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras-arte")
public class ObraArteController {

    private final ObraArteService service;

    @Autowired
    public ObraArteController(ObraArteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ObraArte> create(@RequestBody ObraArte obraArte) {
        // Implemente a lógica necessária para criar uma obra de arte
        ObraArte obraArteCreated = service.create(obraArte);
        return ResponseEntity.status(HttpStatus.CREATED).body(obraArteCreated);
    }

    @PatchMapping("/atualizar-progresso/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarProgresso(@PathVariable Long id) {
        // Implemente a lógica para atualizar o progresso de uma obra de arte
        service.atualizarProgresso(id);
    }

    @GetMapping("/historico-artista/{idArtista}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public HistoricoArtistaDTO historicoArtista(@PathVariable Long idArtista) {
        // Implemente a lógica para retornar o histórico de obras de arte de um artista
        return service.obterHistoricoArtista(idArtista);
    }
}
