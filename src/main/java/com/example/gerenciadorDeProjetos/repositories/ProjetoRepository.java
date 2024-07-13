package com.example.gerenciadorDeProjetos.repositories;

import com.example.gerenciadorDeProjetos.Projeto.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
