package dev.java10x.CadastroDeCaesAR.Caes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DogController {

    //boas vindas
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem!";
    }

    //adicionar(CREATE)
    @PostMapping("/criar")
    public String criar(){
        return "Cão cadastrado.";
    }

    //procurar(CREATE)

    //mostrar todos(READ)
    @GetMapping("/todos")
    public String mostrarTodos(){
        return "Todos os cães";
    }

    //mostrar por id(READ)
    @GetMapping("/mostrarPorID")
    public String mostrarPorID(){
        return "cão com id:";
    }

    //alterar dados(UPDATE)
    @PutMapping("/alterar")
    public String alterarDados(){
        return "dados alterardos";
    }

    //deletar(DELETE)
    @DeleteMapping("/deletar")
    public String deletarCao(){
        return "cão deletado";
    }















}
