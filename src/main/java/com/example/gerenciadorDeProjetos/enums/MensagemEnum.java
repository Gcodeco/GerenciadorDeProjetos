package com.example.gerenciadorDeProjetos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  MensagemEnum {

    INCLUSAO("Inclusão realizada com sucesso"),
    ATUALIZACAO("Atualização realizada com sucesso"),
    EXCLUSAO("Exclusão realizada com sucesso"),
    ERRO("Ocorreu um erro");




    @Getter
    private String value;

}
