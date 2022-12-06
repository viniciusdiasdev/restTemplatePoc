package com.placar.resultado.controller;

import com.placar.resultado.model.Placar;
import com.placar.resultado.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/template")
public class RestController {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    RestTemplateService restTemplateService;
    public String url = "http://localhost:8080/placar";

    @PostMapping("/criar")
    public ResponseEntity<Map<String,Integer>> chamaCreate(@RequestBody Map<String, Integer> placar){
        var result = restTemplateService.startPlacar(placar);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getId(@PathVariable Integer id){
        try{
            String urlTeste = "http://localhost:8080/placar/" + id;
            Placar rtGet = restTemplate.getForObject(urlTeste, Placar.class);
            return new ResponseEntity<>(rtGet, HttpStatus.OK);
        } catch (HttpServerErrorException e){
            return new ResponseEntity<>("Servidor fora do ar",e.getStatusCode());
        } catch (HttpClientErrorException e){
            return new ResponseEntity<>("Placar nao encontrado", e.getStatusCode());
        }
    }
}
