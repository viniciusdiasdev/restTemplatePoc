package com.placar.resultado.repository;

import com.placar.resultado.model.Placar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacarRepository extends JpaRepository<Placar, Long> {
}
