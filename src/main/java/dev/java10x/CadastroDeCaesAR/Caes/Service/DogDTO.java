package dev.java10x.CadastroDeCaesAR.Caes.Service;

import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDTO {

    private Long id;

    private String nome;

    private String dogNome;

    private String email;

    private String imgUrl;

    private String raca;

    private int idade;

    private boolean taxiDog;

    private TreinamentoModel treinamentos;

    private int pontos;

}
