package dev.java10x.CadastroDeCaesAR.Caes.Controller;

import dev.java10x.CadastroDeCaesAR.Caes.Repository.DogRepository;
import dev.java10x.CadastroDeCaesAR.Caes.Service.DogDTO;
import dev.java10x.CadastroDeCaesAR.Caes.Service.DogService;
import dev.java10x.CadastroDeCaesAR.Treinamentos.Repository.TreinamentoRepository;
import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoDTO;
import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caes")
public class DogController {

    private DogService dogService;
    private TreinamentoService treinamentoService;
    private DogRepository dogRepository;

    public DogController(DogService dogService, TreinamentoRepository treinamentoRepository, TreinamentoService treinamentoService) {
        this.dogService = dogService;
        this.dogRepository = dogRepository;
        this.treinamentoService = treinamentoService;
    }

    //boas vindas
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem!";
    }

    //adicionar(CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody DogDTO dogDTO){
        DogDTO dog = dogService.criar(dogDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cadastro criado com sucesso:\n"+"Nome:"+dog.getNome()+"\n(ID):"+dog.getId());

    }

    //mostrar todos(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<DogDTO>> listarTodos(){
        List<DogDTO> dogs = dogService.listarTodos();
        return ResponseEntity.ok(dogs);
    }

    //mostrar por id(READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarPorID(@PathVariable Long id){
        DogDTO dog = dogService.mostrarPorID(id);

        if (dog != null){
            return ResponseEntity.ok(dog);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cadastro (ID): "+id+" ,nao encontrado.");
        }
    }

    //alterar dados(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarDados(@PathVariable Long id,@RequestBody  DogDTO dogAtualizado){

        DogDTO dog = dogService.alterarDados(id,dogAtualizado);

        if (dog != null){
            return ResponseEntity.ok(dog);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cadastro nao encontrado.");
        }
    }

    //deletar(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCao(@PathVariable Long id){
        if (dogService.mostrarPorID(id) != null) {
            dogService.deletarCao(id);
            return ResponseEntity.ok("Cadastro deletado com sucesso.");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cadastro (ID): "+id+" ,nao encontrado.");
        }
    }

    //Concluir treino
    @PatchMapping("/concluirtreino/{id}")
    public ResponseEntity<DogDTO> concluirTreino(@PathVariable Long id,@RequestBody DogDTO dog){
        TreinamentoDTO treinamentoDTO = treinamentoService.mostrarPorID(id);
        DogDTO dogDTO = dogService.mostrarPorID(dog.getId());
        if (treinamentoDTO != null && dogDTO != null){
            dogDTO.setPontos(dogDTO.getPontos()+5);
            treinamentoDTO.setConcluido(true);
            dogService.alterarDados(dogDTO.getId(),dogDTO);
            treinamentoService.alterarTreino(id,treinamentoDTO);
            return ResponseEntity.ok(dogDTO);
        }else
            return ResponseEntity.notFound()
                    .build();
    }

















}
