package com.placar.resultado.model;

import com.placar.resultado.service.PlacarDao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Placar {

    @Id
    private Integer id;

    @Column(name = "Time_A")
    private Integer valor1;

    @Column(name = "Time_B")
    private Integer valor2;

    public Placar(Integer timeA, Integer timeB) {
    }
}
