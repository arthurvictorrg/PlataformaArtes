package com.br.comunidadeArteCultura.service;

import com.br.comunidadeArteCultura.entity.HistoricoArtistaDTO;
import com.br.comunidadeArteCultura.entity.ObraArte;
import com.br.comunidadeArteCultura.repository.HistoricoArtistaDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HistoricoArtistaService {

    @Autowired
    private HistoricoArtistaDTORepository repository;

    public HistoricoArtistaDTO create(HistoricoArtistaDTO historicoArtistaDTO) {
        return repository.save(historicoArtistaDTO);
    }

    public void updateProgresso(InscricaoArtistaProgressoOnlyDTO progressoOnlyDTO, Long inscricaoArtistaId, Long obraArteId) {
        Optional<HistoricoArtistaDTO> historicoArtistaDTO = Optional.ofNullable(repository
                .findByInscricaoArtistaIdAndObraArteId(inscricaoArtistaId, obraArteId));

        boolean needUpdate = false;

        // Implemente a lógica para atualização de progresso conforme necessário.

        repository.save(historicoArtistaDTO.get());
    }

    public HistoricoArtistaDTO getHistoricoFromArtista(Long inscricaoArtistaId) {
        return getHistoricoFromArtista(inscricaoArtistaId);
    }
}
