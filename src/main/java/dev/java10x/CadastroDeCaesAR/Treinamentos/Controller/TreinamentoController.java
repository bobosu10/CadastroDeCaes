package dev.java10x.CadastroDeCaesAR.Treinamentos.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class TreinamentoController {
    //CRUD

    @PostMapping("/criar")
    public String criarTreino(){
        return "Treino criado com sucesso";
    }

    @GetMapping("/mostrarTodosOsTreinos")
    public String mostrarTreinos(){
        return "todos os treinos:";
    }

    @GetMapping
    public String mostrarPorID(){
        return "treino por id:";
    }

    @PutMapping("/alterar")
    public String alterarDados(){
        return "Dados alterados";
    }

    @DeleteMapping
    public String deletarTreino(){
        return "Treino deletado";
    }
}
