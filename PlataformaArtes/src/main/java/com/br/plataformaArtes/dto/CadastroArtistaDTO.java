package com.br.plataformaArtes.dto;

import com.br.comunidadeArteCultura.entity.ComunicadoEmail;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class CadastroArtistaDTO {

    private String nome;
    private String progresso;
    private String status;

    @ManyToOne
    @JoinColumn(name = "Email")
    private ComunicadoEmail email;
}