package dev.java10x.CadastroDeCaesAR.Treinamentos.Service;

import org.springframework.stereotype.Component;

@Component
public class TreinamentoMapper {

    public TreinamentoModel map(TreinamentoDTO treinamentoDTO){
        TreinamentoModel treinamentoModel = new TreinamentoModel();

        treinamentoModel.setId(treinamentoDTO.getId());
        treinamentoModel.setNome(treinamentoDTO.getNome());
        treinamentoModel.setDog(treinamentoDTO.getDog());
        treinamentoModel.setDificuldade(treinamentoDTO.getDificuldade());
        treinamentoModel.setDicas(treinamentoDTO.getDicas());

        return treinamentoModel;
    }

    public TreinamentoDTO map(TreinamentoModel treinamentoModel){
        TreinamentoDTO treinamentoDTO = new TreinamentoDTO();

        treinamentoDTO.setId(treinamentoModel.getId());
        treinamentoDTO.setNome(treinamentoModel.getNome());
        treinamentoDTO.setDog(treinamentoModel.getDog());
        treinamentoDTO.setDificuldade(treinamentoModel.getDificuldade());
        treinamentoDTO.setDicas(treinamentoModel.getDicas());

        return treinamentoDTO;
    }

}
