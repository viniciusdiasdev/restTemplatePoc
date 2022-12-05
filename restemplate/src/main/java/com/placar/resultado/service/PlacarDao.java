package com.placar.resultado.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PlacarDao {
    private Integer valor1;
    private Integer valor2;

    public Integer getValor1() {
        return valor1;
    }

    public Integer getValor2() {
        return valor2;
    }
}
