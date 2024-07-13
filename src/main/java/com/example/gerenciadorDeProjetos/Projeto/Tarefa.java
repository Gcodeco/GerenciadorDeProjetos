package com.example.gerenciadorDeProjetos.Projeto;

import com.example.gerenciadorDeProjetos.enums.Prioridade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "prioridade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Column(name = "estimativa_em_horas", nullable = false)
    private int estimativaEmHoras;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;


}
