package com.br.comunidadeArteCultura.service;

import com.br.comunidadeArteCultura.entity.ObraArte;
import com.br.comunidadeArteCultura.entity.Artista;
import com.br.comunidadeArteCultura.repository.ObraArteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraArteService {

    @Autowired
    private ObraArteRepository repository;

    public ObraArte create(ObraArte obraArte) {
        return repository.save(obraArte);
    }

    public List<ObraArte> findAll() {
        return repository.findAll();
    }

    public Optional<ObraArte> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Artista> buscarListaArtistas(Long idObraArte) {
        return repository.listarArtistasPorObraArte(idObraArte);
    }
}
