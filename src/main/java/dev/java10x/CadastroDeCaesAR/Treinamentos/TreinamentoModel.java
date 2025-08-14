package dev.java10x.CadastroDeCaesAR.Treinamentos;

import dev.java10x.CadastroDeCaesAR.Caes.DogModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_treinamentos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreinamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private Dificuldade dificuldade;

    private String dicas;

    @OneToMany(mappedBy = "treinamentos")
    private List<DogModel> dog;


}
