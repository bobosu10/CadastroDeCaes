package dev.java10x.CadastroDeCaesAR.Caes.Controller;

import dev.java10x.CadastroDeCaesAR.Caes.Service.DogModel;
import dev.java10x.CadastroDeCaesAR.Caes.Service.DogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caes")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    //boas vindas
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem!";
    }

    //adicionar(CREATE)
    @PostMapping("/criar")
    public DogModel criar(@RequestBody DogModel dogModel){
        return dogService.criar(dogModel);
    }

    //procurar(CREATE)

    //mostrar todos(READ)
    @GetMapping("/listar")
    public List<DogModel> listarTodos(){
        return dogService.listarTodos();
    }

    //mostrar por id(READ)
    @GetMapping("/listar/{id}")
    public DogModel mostrarPorID(@PathVariable Long id){
        return dogService.mostrarPorID(id);
    }

    //alterar dados(UPDATE)
    @PutMapping("/alterar/{id}")
    public DogModel alterarDados(@PathVariable Long id,@RequestBody  DogModel dogAtualizado){
        return dogService.alterarDados(id,dogAtualizado);
    }

    //deletar(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarCao(@PathVariable Long id){
        dogService.deletarCao(id);
    }















}
