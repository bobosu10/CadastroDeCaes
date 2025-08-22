package dev.java10x.CadastroDeCaesAR.Caes.Service;

import dev.java10x.CadastroDeCaesAR.Caes.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;
    private DogMapper dogMapper;

    public DogService(DogMapper dogMapper, DogRepository dogRepository) {
        this.dogMapper = dogMapper;
        this.dogRepository = dogRepository;
    }

    //criar

    public DogDTO criar(DogDTO dogDTO){
        DogModel dog = dogMapper.map(dogDTO);
        dog = dogRepository.save(dog);
        return dogMapper.map(dog);
    }

    //listar

    public List<DogDTO> listarTodos(){
        List<DogModel> dogs = dogRepository.findAll();
        return dogs.stream()
                .map(dogMapper::map)
                .collect(Collectors.toList());
    }

    //listar por id

    public DogDTO mostrarPorID(Long id){
        Optional<DogModel> dogPorID = dogRepository.findById(id);
        return dogPorID.map(dogMapper::map).orElse(null);
    }

    //deletar

    public String deletarCao(Long id){
        Optional<DogModel> deletarPorID = dogRepository.findById(id);
        if (deletarPorID.isPresent()) {
            dogRepository.deleteById(id);
            return "cao deletado";
        }else{
            return "cao nao encontrado";
        }
    }

    //alterar
    public DogDTO alterarDados(Long id,DogDTO dogDTO){
        Optional<DogModel> dogExistente = dogRepository.findById(id);
        if(dogExistente.isPresent()){
            DogModel dogAtualizado = dogMapper.map(dogDTO);
            dogAtualizado.setId(id);
            DogModel dogSalvo = dogRepository.save(dogAtualizado);
            return dogMapper.map(dogSalvo);
        }
        return null;
    }






}
