package com.example.gerenciadorDeProjetos.controller;

import com.example.gerenciadorDeProjetos.dto.ProjetoDTO;
import com.example.gerenciadorDeProjetos.Service.ProjetoService;
import com.example.gerenciadorDeProjetos.enums.MensagemEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;


    @GetMapping("/teste")
    public String teste (){
        return "teste";
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody ProjetoDTO projetoDTO){
        try {
            projetoService.salvar(projetoDTO);
            return ResponseEntity.ok(MensagemEnum.INCLUSAO.getValue());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity listarTodos(){
        try{
            List<ProjetoDTO> projetos = projetoService.listarTodos();
            return  ResponseEntity.ok(projetos);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<ProjetoDTO> visualizar(@PathVariable Long id) {
        try {
            ProjetoDTO projetoDTO = projetoService.visualizar(id);
            return ResponseEntity.ok(projetoDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody ProjetoDTO projetoDTO) {
        try {
            projetoService.editar(id, projetoDTO);
            return ResponseEntity.ok(MensagemEnum.ATUALIZACAO.getValue());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            projetoService.excluir(id);
            return ResponseEntity.ok(MensagemEnum.EXCLUSAO.getValue());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
