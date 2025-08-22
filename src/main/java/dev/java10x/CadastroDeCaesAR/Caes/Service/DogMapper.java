package dev.java10x.CadastroDeCaesAR.Caes.Service;

import org.springframework.stereotype.Component;

@Component
public class DogMapper {

    public DogModel map(DogDTO dogDTO){
        DogModel dogModel = new DogModel();
        dogModel.setId(dogDTO.getId());
        dogModel.setDogNome(dogDTO.getDogNome());
        dogModel.setTaxiDog(dogDTO.isTaxiDog());
        dogModel.setIdade(dogDTO.getIdade());
        dogModel.setEmail(dogDTO.getEmail());
        dogModel.setRaca(dogDTO.getRaca());
        dogModel.setImgUrl(dogDTO.getImgUrl());
        dogModel.setTreinamentos(dogDTO.getTreinamentos());
        dogModel.setNome(dogDTO.getNome());
        dogModel.setPontos(dogDTO.getPontos());

        return dogModel;
    }

    public DogDTO map(DogModel dogModel){
        DogDTO dogDTO = new DogDTO();
        dogDTO.setId(dogModel.getId());
        dogDTO.setDogNome(dogModel.getDogNome());
        dogDTO.setTaxiDog(dogModel.isTaxiDog());
        dogDTO.setIdade(dogModel.getIdade());
        dogDTO.setEmail(dogModel.getEmail());
        dogDTO.setRaca(dogModel.getRaca());
        dogDTO.setImgUrl(dogModel.getImgUrl());
        dogDTO.setTreinamentos(dogModel.getTreinamentos());
        dogDTO.setNome(dogModel.getNome());
        dogDTO.setPontos(dogModel.getPontos());

        return dogDTO;
    }
}
