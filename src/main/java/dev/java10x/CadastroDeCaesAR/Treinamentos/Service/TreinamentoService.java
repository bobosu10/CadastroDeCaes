package dev.java10x.CadastroDeCaesAR.Treinamentos.Service;


import dev.java10x.CadastroDeCaesAR.Treinamentos.Repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinamentoService {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    //criar

    public TreinamentoModel criarTreino(TreinamentoModel treinamentoModel){
        return treinamentoRepository.save(treinamentoModel);
    }

    //listar

    public List<TreinamentoModel> mostrarTreinos(){
        return treinamentoRepository.findAll();
    }

    //lisarPorID

    public TreinamentoModel mostrarPorID(Long id){
        Optional<TreinamentoModel> treinoPorID = treinamentoRepository.findById(id);
        return treinoPorID.orElse(null);
    }

    //alterar

    public TreinamentoModel alterarDados(Long id, TreinamentoModel treinoAtualizado){
        if (treinamentoRepository.existsById(id)){
            treinoAtualizado.setId(id);
            return treinamentoRepository.save(treinoAtualizado);
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
