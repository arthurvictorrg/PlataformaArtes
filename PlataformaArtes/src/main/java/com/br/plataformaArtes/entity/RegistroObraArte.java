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
public class RegistroObraArte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "obra_arte_id")
    private ObraArte obraArte;

    private String status;

    // Outros campos relevantes para registrar obras de arte em uma comunidade de arte e cultura.

    // Getters e setters, construtores, etc.
}
