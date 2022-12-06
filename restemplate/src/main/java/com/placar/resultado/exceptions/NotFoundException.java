package com.placar.resultado.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4928599035264976611L;
    private String devMessage;
    private Integer status;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable t) {
        super(t);
    }
}
