package com.br.comunidadeArteCultura.repository;

import com.br.comunidadeArteCultura.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Evento, Long> {
}
