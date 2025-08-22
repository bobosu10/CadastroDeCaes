package dev.java10x.CadastroDeCaesAR.Treinamentos.Controller;

import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoDTO;
import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinamentoController {

    private TreinamentoService treinamentoService;

    public TreinamentoController(TreinamentoService treinamentoService) {
        this.treinamentoService = treinamentoService;
    }

    //CRUD

    @PostMapping("/criar")
    public ResponseEntity<String> criarTreino(@RequestBody TreinamentoDTO treinamentoDTO) {
        TreinamentoDTO treino = treinamentoService.criarTreino(treinamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao cadastrada com sucesso.");
    }

    @GetMapping("/mostrarTodosOsTreinos")
    public ResponseEntity<List<TreinamentoDTO>> mostrarTreinos() {
        List<TreinamentoDTO> treinos = treinamentoService.mostrarTreinos();
        return ResponseEntity.ok(treinos);
    }

    @GetMapping("/mostrarTodosOsTreinos/{id}")
    public ResponseEntity<?> mostrarPorID(@PathVariable Long id) {

        TreinamentoDTO treino = treinamentoService.mostrarPorID(id);

        if (treino != null) {
            return ResponseEntity.ok(treino);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Treino nao encontrado.");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarDados(@PathVariable Long id, @RequestBody TreinamentoDTO treinamentoAtualizado) {
        TreinamentoDTO treino = treinamentoService.alterarDados(id, treinamentoAtualizado);
        if (treino != null) {
            return ResponseEntity.ok(treino);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Treino com " + id + " nao encontrado.");
        }
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTreino(@PathVariable Long id) {
        if (treinamentoService.mostrarPorID(id) != null){
            treinamentoService.deletarTreino(id);
            return ResponseEntity.ok("Treino deletado com sucesso");
        }else {
            return ResponseEntity.status( HttpStatus.NOT_FOUND)
                    .body("Cadastro de treino nao encontrado.");
        }
    }
}

