package com.example.gerenciadorDeProjetos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Prioridade {

    MUITO_ALTA("Muito Alta"),
    ALTA("Alta"),
    BAIXA ("Baixa"),
    MUITO_BAIXA("Muito Baixa");

    @Getter
    private String value;

}
