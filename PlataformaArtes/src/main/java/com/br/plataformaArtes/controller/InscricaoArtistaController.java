package com.br.comunidadeArteCultura.controller;

import com.br.comunidadeArteCultura.entity.InscricaoArtista;
import com.br.comunidadeArteCultura.service.InscricaoArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricao-artista")
public class InscricaoArtistaController {

    private final InscricaoArtistaService service;

    @Autowired
    public InscricaoArtistaController(InscricaoArtistaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InscricaoArtista> create(@RequestBody InscricaoArtista inscricaoArtista) {
        InscricaoArtista inscricaoArtistaCreated = service.create(inscricaoArtista);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoArtistaCreated);
    }

    @PatchMapping("/aprovar-inscricao/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchStatus(@PathVariable Long id) throws Exception {
        service.aprovarInscricao(id);
    }

    @GetMapping(value = "/artista/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')") // Ajuste as permissões conforme necessário
    public List<com.br.comunidadeArteCultura.entity.Mentor> retornaArtistasPorStatus(@PathVariable String status) {
        return service.retornaArtistasPorStatus(status);
    }
}
