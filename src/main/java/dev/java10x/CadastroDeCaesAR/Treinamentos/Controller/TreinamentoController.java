package dev.java10x.CadastroDeCaesAR.Treinamentos.Controller;

import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoDTO;
import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoModel;
import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoService;
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
    public TreinamentoDTO criarTreino(@RequestBody TreinamentoDTO treinamentoDTO){
        return treinamentoService.criarTreino(treinamentoDTO);
    }

    @GetMapping("/mostrarTodosOsTreinos")
    public List<TreinamentoDTO> mostrarTreinos(){
        return treinamentoService.mostrarTreinos();
    }

    @GetMapping("/mostrarTodosOsTreinos/{id}")
    public TreinamentoDTO mostrarPorID(@PathVariable Long id){
        return treinamentoService.mostrarPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public TreinamentoDTO alterarDados(@PathVariable Long id, @RequestBody TreinamentoDTO treinamentoAtualizado){
        return treinamentoService.alterarDados(id,treinamentoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTreino(@PathVariable Long id){
        treinamentoService.deletarTreino(id);
    }
}
