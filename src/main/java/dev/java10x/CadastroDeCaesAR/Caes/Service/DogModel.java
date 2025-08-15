package dev.java10x.CadastroDeCaesAR.Caes.Service;

import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "DogNome")
    private String dogNome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "raca")
    private String raca;

    @Column(name = "idade")
    private int idade;

    @Column(name = "taxiDog")
    private boolean taxiDog;

    @ManyToOne
    @JoinColumn(name = "treinamentos_id") //chave estrangeira foreing key
    private TreinamentoModel treinamentos;


}
