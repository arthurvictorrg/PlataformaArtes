package com.br.comunidadeArteCultura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunicadoEmail extends JpaRepository<com.br.comunidadeArteCultura.entity.ComunicadoEmail, Long> {
}
