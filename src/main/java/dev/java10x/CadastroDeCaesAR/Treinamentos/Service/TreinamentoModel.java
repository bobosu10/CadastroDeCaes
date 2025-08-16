package dev.java10x.CadastroDeCaesAR.Treinamentos.Service;

import dev.java10x.CadastroDeCaesAR.Caes.Service.DogModel;
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
    @Column(name = "ID")
    private long id;

    @Column(name = "treino")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "dificuldade")
    private Dificuldade dificuldade;

    @Column(name = "dicas")
    private String dicas;

    @OneToMany(mappedBy = "treinamentos")
    private List<DogModel> dog;


}
