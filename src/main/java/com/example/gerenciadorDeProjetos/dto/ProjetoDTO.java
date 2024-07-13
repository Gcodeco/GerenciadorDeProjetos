package com.example.gerenciadorDeProjetos.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ProjetoDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private Instant dataDeInicio;


}
