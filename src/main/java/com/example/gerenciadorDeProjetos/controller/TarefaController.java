package com.example.gerenciadorDeProjetos.controller;


import com.example.gerenciadorDeProjetos.Projeto.Tarefa;
import com.example.gerenciadorDeProjetos.Service.TarefaService;
import com.example.gerenciadorDeProjetos.dto.TarefaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/tarefas")
    public class TarefaController {

        @Autowired
        private TarefaService tarefaService;

        @PostMapping("/criar")
        public ResponseEntity<String> criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
            try {
                tarefaService.criarTarefa(tarefaDTO);
                return ResponseEntity.ok("Tarefa criada com sucesso");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/listar")
        public ResponseEntity<List<Tarefa>> listarTarefas() {
            List<Tarefa> tarefas = tarefaService.listarTarefas();
            return ResponseEntity.ok(tarefas);
        }

        @GetMapping("/visualizar/{id}")
        public ResponseEntity<Tarefa> visualizarTarefa(@PathVariable Long id) {
            try {
                Tarefa tarefa = tarefaService.visualizarTarefa(id);
                return ResponseEntity.ok(tarefa);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(null);
            }
        }

        @PutMapping("/editar/{id}")
        public ResponseEntity<String> editarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
            try {
                tarefaService.editarTarefa(id, tarefaAtualizada);
                return ResponseEntity.ok("Tarefa atualizada com sucesso");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/excluir/{id}")
        public ResponseEntity<String> excluirTarefa(@PathVariable Long id) {
            try {
                tarefaService.excluirTarefa(id);
                return ResponseEntity.ok("Tarefa excluída com sucesso");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

