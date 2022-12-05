package com.placar.resultado.service;

import com.placar.resultado.model.Placar;
import com.placar.resultado.repository.PlacarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class PlacarService {

    @Autowired
    private PlacarRepository placarRepository;
    public void createPlacar(PlacarDao placarDao){
        Integer id = criaId();
        Placar placar = new Placar(id, placarDao.getValor1(), placarDao.getValor2());
        placarRepository.save(placar);
    }

    public Integer criaId(){
        Random ran = new Random();
        int x = ran.nextInt(1) + 100;
        return x;
    }
}
