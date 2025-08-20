package dev.java10x.CadastroDeCaesAR.Caes.Controller;

import dev.java10x.CadastroDeCaesAR.Caes.Service.DogDTO;
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
    public DogDTO criar(@RequestBody DogDTO dog){
        return dogService.criar(dog);
    }

    //procurar(CREATE)

    //mostrar todos(READ)
    @GetMapping("/listar")
    public List<DogDTO> listarTodos(){
        return dogService.listarTodos();
    }

    //mostrar por id(READ)
    @GetMapping("/listar/{id}")
    public DogDTO mostrarPorID(@PathVariable Long id){
        return dogService.mostrarPorID(id);
    }

    //alterar dados(UPDATE)
    @PutMapping("/alterar/{id}")
    public DogDTO alterarDados(@PathVariable Long id,@RequestBody  DogDTO dogAtualizado){
        return dogService.alterarDados(id,dogAtualizado);
    }

    //deletar(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarCao(@PathVariable Long id){
        dogService.deletarCao(id);
    }















}
