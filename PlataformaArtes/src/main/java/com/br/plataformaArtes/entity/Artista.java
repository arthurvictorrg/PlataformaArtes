package com.br.comunidadeArteCultura.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataNasc;

    private String genero;

    private String numTel;

    private String email;

    private String obrasArte;

    // Outros campos relevantes para um artista em uma comunidade de arte e cultura.

    // Getters e setters, construtores, etc.
}
