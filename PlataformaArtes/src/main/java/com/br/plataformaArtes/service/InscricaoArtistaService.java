package com.br.comunidadeArteCultura.service;

import com.br.comunidadeArteCultura.entity.InscricaoArtista;
import com.br.comunidadeArteCultura.entity.Artista;
import com.br.comunidadeArteCultura.repository.InscricaoArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InscricaoArtistaService {

    @Autowired
    private InscricaoArtistaRepository repository;

    public InscricaoArtista create(InscricaoArtista inscricaoArtista) {
        inscricaoArtista.setStatus("INSCRITO");
        return repository.save(inscricaoArtista);
    }

    public void trancarInscricao(Long inscricaoArtistaId) throws Exception {
        Optional<InscricaoArtista> inscricaoArtistaToUpdate = repository.findById(inscricaoArtistaId);

        if (inscricaoArtistaToUpdate.isPresent()) {
            if (Objects.equals(inscricaoArtistaToUpdate.get().getStatus(), "INSCRITO")) {
                inscricaoArtistaToUpdate.ifPresent(inscricaoArtista -> inscricaoArtista.setStatus("TRANCADO"));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possível trancar com status INSCRITO.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscrição não encontrada.");
        }
        repository.save(inscricaoArtistaToUpdate.get());
    }

    public List<Artista> listarArtistasPorStatus(String status) {
        return repository.listarArtistasPorStatus(status);
    }
}
