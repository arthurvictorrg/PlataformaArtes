package com.br.comunidadeArteCultura.service;

import com.br.comunidadeArteCultura.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository repository;

    public List<com.br.comunidadeArteCultura.entity.Artista> listarTodos() {
        return repository.findAll();
    }

    public List<com.br.comunidadeArteCultura.entity.Artista> listarPorNome(String nome) {
        return repository.findByNomeContainsIgnoreCase(nome);
    }

    public List<com.br.comunidadeArteCultura.entity.Artista> listarPorNomeOuEmail(com.br.comunidadeArteCultura.entity.Artista dto) {
        return repository.findByNomeOrEmail(dto.getNome(), dto.getEmail());
    }

    @Transactional
    public void atualizarEmailArtista(String email, Long id) {
        repository.atualizarEmailArtista(email, id);
    }

    public List<com.br.comunidadeArteCultura.entity.Artista> listarArtistasPorEvento(Long idEvento) {
        return repository.listarArtistasPorEvento(idEvento);
    }
}
