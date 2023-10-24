package com.br.comunidadeArteCultura.repository;

import com.br.comunidadeArteCultura.entity.RegistroObraArte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroObraArteRepository extends JpaRepository<RegistroObraArte, Long> {

    RegistroObraArte findByInscricaoArtistaIdAndObraArteId(Long inscricaoArtistaId, Long obraArteId);

    List<RegistroObraArte> findByInscricaoArtistaId(Long inscricaoArtistaId);
}
