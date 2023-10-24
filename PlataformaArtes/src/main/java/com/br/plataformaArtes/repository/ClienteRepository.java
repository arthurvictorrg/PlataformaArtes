package com.br.comunidadeArteCultura.repository;

import com.br.comunidadeArteCultura.entity.Artista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Artista, Long> {

    List<Artista> findByNomeContainsIgnoreCase(String nome);

    List<Artista> findByNomeOrEmail(String nome, String email);

    @Query("update Artista a set a.email = ?1 where a.id = ?2")
    void atualizarEmailArtista(String email, Long id);

    @Query(value = "select " +
            "    a.* " +
            "    from " +
            "    comunidade_arte_cultura.artista a " +
            "    inner join inscricao_artista ia on " +
            "    ia.artista_id = a.id " +
            "    inner join evento e on " +
            "    e.id = ia.evento_id " +
            "            where " +
            "    e.id = ?1", nativeQuery = true)
    List<Artista> listarArtistasPorEvento(Long idEvento);
}
