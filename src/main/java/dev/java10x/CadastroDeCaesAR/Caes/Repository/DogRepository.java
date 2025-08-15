package dev.java10x.CadastroDeCaesAR.Caes.Repository;

import dev.java10x.CadastroDeCaesAR.Caes.Service.DogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<DogModel, Long> {
}
