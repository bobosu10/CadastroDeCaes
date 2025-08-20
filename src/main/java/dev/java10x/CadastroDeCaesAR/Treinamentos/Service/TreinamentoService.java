package dev.java10x.CadastroDeCaesAR.Treinamentos.Service;


import dev.java10x.CadastroDeCaesAR.Treinamentos.Repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreinamentoService {

    @Autowired
    private TreinamentoRepository treinamentoRepository;
    private TreinamentoMapper treinamentoMapper;

    public TreinamentoService(TreinamentoMapper treinamentoMapper, TreinamentoRepository treinamentoRepository) {
        this.treinamentoMapper = treinamentoMapper;
        this.treinamentoRepository = treinamentoRepository;
    }

    //criar

    public TreinamentoDTO criarTreino(TreinamentoDTO treinamentoDTO){
        TreinamentoModel treino = treinamentoMapper.map(treinamentoDTO);
        treino = treinamentoRepository.save(treino);
        return treinamentoMapper.map(treino);
    }

    //listar

    public List<TreinamentoDTO> mostrarTreinos(){
        List<TreinamentoModel> treinos = treinamentoRepository.findAll();
        return treinos.stream()
                .map(treinamentoMapper::map)
                .collect(Collectors.toList());
    }

    //lisarPorID

    public TreinamentoDTO mostrarPorID(Long id){
        Optional<TreinamentoModel> treinoPorID = treinamentoRepository.findById(id);
        return treinoPorID.map(treinamentoMapper::map).orElse(null);
    }

    //alterar

    public TreinamentoDTO alterarDados(Long id, TreinamentoDTO treinamentoDTO){
        Optional<TreinamentoModel> treinoExiste = treinamentoRepository.findById(id);
        if (treinoExiste.isPresent()){
            TreinamentoModel treinoAtualizado = treinamentoMapper.map(treinamentoDTO);
            treinoAtualizado.setId(id);
            TreinamentoModel treinoSalvo = treinamentoRepository.save(treinoAtualizado);
            return treinamentoMapper.map(treinoSalvo);
        }
        return null;
    }

    //deletar

    public void deletarTreino(Long id){
        Optional<TreinamentoModel> treinamentoExiste = treinamentoRepository.findById(id);
        if (treinamentoExiste.isPresent()){
            treinamentoRepository.deleteById(id);
        }
    }
}
