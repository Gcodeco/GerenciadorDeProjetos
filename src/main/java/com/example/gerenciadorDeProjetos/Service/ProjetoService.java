package com.example.gerenciadorDeProjetos.Service;

import com.example.gerenciadorDeProjetos.dto.ProjetoDTO;
import com.example.gerenciadorDeProjetos.Projeto.Projeto;
import com.example.gerenciadorDeProjetos.repositories.ProjetoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void salvar(ProjetoDTO projetoDTO) throws Exception{
        Projeto projeto = new ModelMapper().map(projetoDTO, Projeto.class);
        projetoRepository.save(projeto);
    }

    public List<ProjetoDTO> listarTodos() throws Exception{
        return projetoRepository.findAll().stream().map(p -> {
            return  new ModelMapper().map(p, ProjetoDTO.class);
        }).collect(Collectors.toList());
    }

    public ProjetoDTO visualizar(Long id) throws    Exception{
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()) {
            return modelMapper.map(projeto.get(), ProjetoDTO.class);
        }else{
            throw new Exception("com.example.gerenciadorDeProjetos.Projeto não Encontrado");
        }
    }

    public void editar(Long id, ProjetoDTO projetoDTO) throws Exception {
        Optional<Projeto> projetoOptional = projetoRepository.findById(id);
        if(projetoOptional.isPresent()){
            Projeto projeto = projetoOptional.get();
            projeto.setTitulo(projetoDTO.getTitulo());
            projeto.setDescricao(projetoDTO.getDescricao());
            projetoRepository.save(projeto);
        }else {
            throw new Exception("com.example.gerenciadorDeProjetos.Projeto não encontrado");
        }
    }

    public void excluir(Long id) throws Exception{
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
            projetoRepository.delete(projeto.get());
        }else{
            throw new Exception("com.example.gerenciadorDeProjetos.Projeto não Encontrado");
        }

    }
}
