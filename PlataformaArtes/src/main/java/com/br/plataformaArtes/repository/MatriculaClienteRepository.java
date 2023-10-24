package com.br.comunidadeArteCultura.repository;

import com.br.comunidadeArteCultura.entity.InscricaoArtista;
import com.br.comunidadeArteCultura.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaClienteRepository extends JpaRepository<InscricaoArtista, Long> {
    public List<InscricaoArtista> findByArtistaId(Long artistaId);

    @Query(value = "SELECT AVG(progresso) FROM inscricao_artista e", nativeQuery = true)
    public Double retornaMediaProgresso();

    public List<InscricaoArtista> findByStatus(String status);

    @Query(value = "select a from InscricaoArtista ia, Artista a where a.id = ia.artista.id and " +
            " ia.status = :status")
    public List<Artista> listarArtistasPorStatus(String status);
}
