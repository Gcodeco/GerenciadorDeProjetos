package com.example.gerenciadorDeProjetos.dto;



import com.example.gerenciadorDeProjetos.enums.Prioridade;
import lombok.Data;

@Data
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private int estimativaEmHoras;
    private Long projetoId;
}
