package com.example.gerenciadorDeProjetos.Service;

import com.example.gerenciadorDeProjetos.Projeto.Projeto;
import com.example.gerenciadorDeProjetos.Projeto.Tarefa;
import com.example.gerenciadorDeProjetos.dto.TarefaDTO;
import com.example.gerenciadorDeProjetos.repositories.ProjetoRepository;
import com.example.gerenciadorDeProjetos.repositories.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Tarefa criarTarefa(TarefaDTO tarefaDTO) throws Exception {
        Projeto projeto = projetoRepository.findById(tarefaDTO.getProjetoId()).orElseThrow(() -> new Exception("Projeto não encontrado"));
        Tarefa tarefa = modelMapper.map(tarefaDTO, Tarefa.class);
        tarefa.setProjeto(projeto);
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas(){
        return  tarefaRepository.findAll();
    }

    public  Tarefa visualizarTarefa(Long id) throws Exception{
        return tarefaRepository.findById(id).orElseThrow(() -> new Exception("Tarefa não encontarda "));
    }

    public void editarTarefa(Long id, Tarefa tarefaAtualizada) throws Exception{
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setPrioridade(tarefaAtualizada.getPrioridade());
            tarefa.setEstimativaEmHoras(tarefaAtualizada.getEstimativaEmHoras());
            tarefa.setProjeto(tarefaAtualizada.getProjeto());
            tarefaRepository.save(tarefa);
        } else {
            throw new Exception("Tarefa não encontrada");
        }
    }

    public void excluirTarefa(Long id) throws Exception {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isPresent()) {
            tarefaRepository.delete(tarefa.get());
        } else {
            throw new Exception("Tarefa não encontrada");
        }
    }



}

