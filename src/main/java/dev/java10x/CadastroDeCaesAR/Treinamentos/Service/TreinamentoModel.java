package dev.java10x.CadastroDeCaesAR.Treinamentos.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private long id;

    @Column(name = "treino")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "dificuldade")
    private Dificuldade dificuldade;

    @Column(name = "dicas")
    private String dicas;

    @Column(name = "concluido")
    private boolean concluido;

    @OneToMany(mappedBy = "treinamentos")
    @JsonIgnore
    private List<DogModel> dog;


}
