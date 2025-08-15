package dev.java10x.CadastroDeCaesAR.Treinamentos.Repository;

import dev.java10x.CadastroDeCaesAR.Treinamentos.Service.TreinamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinamentoRepository extends JpaRepository<TreinamentoModel, Long> {
}
