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
public class ComunicadoEmail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assunto;

    private String conteudo;

    // Outros campos relevantes para um comunicado de email em uma comunidade de arte e cultura.

    // Getters e setters, construtores, etc.
}
