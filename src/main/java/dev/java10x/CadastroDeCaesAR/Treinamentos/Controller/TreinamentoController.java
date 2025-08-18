package dev.java10x.CadastroDeCaesAR.Treinamentos.Controller;

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
    public TreinamentoModel criarTreino(@RequestBody TreinamentoModel treinamentoModel){
        return treinamentoService.criarTreino(treinamentoModel);
    }

    @GetMapping("/mostrarTodosOsTreinos")
    public List<TreinamentoModel> mostrarTreinos(){
        return treinamentoService.mostrarTreinos();
    }

    @GetMapping("/mostrarTodosOsTreinos/{id}")
    public TreinamentoModel mostrarPorID(@PathVariable Long id){
        return treinamentoService.mostrarPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public TreinamentoModel alterarDados(@PathVariable Long id, @RequestBody TreinamentoModel treinamentoAtualizado){
        return treinamentoService.alterarDados(id,treinamentoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTreino(@PathVariable Long id){
        treinamentoService.deletarTreino(id);
    }
}
