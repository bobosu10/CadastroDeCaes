package dev.java10x.CadastroDeCaesAR.Caes;

import dev.java10x.CadastroDeCaesAR.Treinamentos.TreinamentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dogNome;

    @Column(unique = true)
    private String email;

    private String raca;

    private int idade;

    private boolean taxiDog;

    @ManyToOne
    @JoinColumn(name = "treinamentos_id") //chave estrangeira foreing key
    private TreinamentoModel treinamentos;


}
