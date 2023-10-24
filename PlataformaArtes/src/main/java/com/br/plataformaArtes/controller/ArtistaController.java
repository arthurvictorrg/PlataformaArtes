package com.br.comunidadeArteCultura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    private final com.br.comunidadeArteCultura.service.ArtistaService service;

    @Autowired
    public ArtistaController(com.br.comunidadeArteCultura.service.ArtistaService service) {
        this.service = service;
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<com.br.comunidadeArteCultura.entity.Mentor> findAll() {
        return service.listaTodos();
    }

    @GetMapping("/listar-por-nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<com.br.comunidadeArteCultura.entity.Mentor> buscarNome(@PathVariable String nome) {
        return service.listaPorNome(nome);
    }

    @PostMapping("/listar-por-nome-email")
    @ResponseStatus(HttpStatus.OK)
    public List<com.br.comunidadeArteCultura.entity.Mentor> buscarNomeOrEmail(@RequestBody com.br.comunidadeArteCultura.entity.Mentor dto) {
        return service.listaPorNomeOrEmail(dto);
    }

    @GetMapping("/atualiza-email/{email}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizaEmail(@PathVariable String email, @PathVariable Long id, Principal principal) {
        // Verifique se o usuário autenticado tem permissão para atualizar o email do artista
        // Implemente a lógica para verificar as permissões do usuário autenticado.
        // Exemplo: se (temPermissaoAtualizarEmail(principal)) { service.atualizaEmailArtista(email, id); }
    }

    @GetMapping("/listar-artista-evento/{idEvento}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<com.br.comunidadeArteCultura.entity.Mentor> listarArtistaEvento(@PathVariable Long idEvento) {
        return service.listaArtistaEvento(idEvento);
    }

    // Adicione outros endpoints conforme necessário para suportar a Comunidade de Arte e Cultura.
}
