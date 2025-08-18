package dev.java10x.CadastroDeCaesAR.Caes.Service;

import dev.java10x.CadastroDeCaesAR.Caes.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    //criar

    public DogModel criar(DogModel dogModel){
        return dogRepository.save(dogModel);
    }

    //listar

    public List<DogModel> listarTodos(){
        return dogRepository.findAll();
    }

    //listar por id

    public DogModel mostrarPorID(Long id){
        Optional<DogModel> dogPorID = dogRepository.findById(id);
        return dogPorID.orElse(null);
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
    public DogModel alterarDados(Long id,DogModel dogAtualizado){
        if(dogRepository.existsById(id)){
            dogAtualizado.setId(id);
            return dogRepository.save(dogAtualizado);
        }
        return null;
    }

}
