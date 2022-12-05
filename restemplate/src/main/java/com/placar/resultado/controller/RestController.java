package com.placar.resultado.controller;

import com.placar.resultado.model.Placar;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("template")
public class RestController {

    RestTemplate restTemplate = new RestTemplate();

    public String url = "http://localhost:8080/placar";

    @GetMapping("/{id}")
    public ResponseEntity<Object> getId(@PathVariable Integer id){
        String urlTeste = "http://localhost:8080/placar/" + id;
        Placar rtGet = restTemplate.getForObject(urlTeste, Placar.class);
        return new ResponseEntity<>(rtGet, HttpStatus.OK);
    }

}
