package com.placar.resultado.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.placar.resultado.errorHandling.RestTemplateResponseErrorHandler;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@Service
public class RestTemplateService {

    RestTemplate restTemplate;

    public String url = "http://localhost:8080/placar/notfound";

    public RestTemplateService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    public Map<String, Integer> consumeById(Integer id){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("token","valor do token");

        HttpEntity<String> entity = new HttpEntity<>("",headers);

        return null;
    }

    @SneakyThrows
    public Map<String,Integer> startPlacar(Map<String, Integer> placar){
        HttpHeaders headers = new HttpHeaders();
        headers.add("token","123");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        var mapper = new ObjectMapper();

        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(placar),headers);

        Map<String,Integer> resultado = restTemplate.postForObject(url, entity, Map.class);

        System.out.println(resultado.toString());

        return resultado;
    }

}
