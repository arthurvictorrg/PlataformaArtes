package com.br.plataformaArtes.dto;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoClienteDTO {

    private String nomeCliente;
    private com.br.plataformaArtes.entity.Consulta Consulta;
    private List<ConsultasClienteDTO> ConsultasClienteDTO;
}