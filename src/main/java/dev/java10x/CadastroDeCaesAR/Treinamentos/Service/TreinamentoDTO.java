package dev.java10x.CadastroDeCaesAR.Treinamentos.Service;

import dev.java10x.CadastroDeCaesAR.Caes.Service.DogModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreinamentoDTO {

    private long id;

    private String nome;

    private Dificuldade dificuldade;

    private String dicas;

    private List<DogModel> dog;

}
