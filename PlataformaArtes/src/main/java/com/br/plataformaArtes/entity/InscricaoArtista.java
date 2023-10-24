package com.br.comunidadeArteCultura.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InscricaoArtista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int progresso;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private String status;

    // Outros campos relevantes para a inscrição de artistas em uma comunidade de arte e cultura.

    // Getters e setters, construtores, etc.
}
