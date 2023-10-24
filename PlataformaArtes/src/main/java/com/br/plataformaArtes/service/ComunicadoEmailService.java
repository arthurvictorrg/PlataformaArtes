package com.br.comunidadeArteCultura.service;

import com.br.comunidadeArteCultura.repository.ComunicadoEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComunicadoEmailService {

    @Autowired
    private ComunicadoEmailRepository repository;

    public com.br.comunidadeArteCultura.entity.ComunicadoEmail salvar(com.br.comunidadeArteCultura.entity.ComunicadoEmail comunicadoEmail) {
        return repository.save(comunicadoEmail);
    }

    public Optional<com.br.comunidadeArteCultura.entity.ComunicadoEmail> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
