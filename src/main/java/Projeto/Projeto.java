package Projeto;

import jakarta.persistence.*;
import lombok.*;


import java.time.Instant;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "data_de_inicio")
    private Instant dataDeInicio;


    @PrePersist
    private void prePersist() {dataDeInicio = Instant.now(); }
}
