package com.example.gerenciadorDeProjetos.repositories;

import com.example.gerenciadorDeProjetos.Projeto.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
