package com.udesc.iwe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udesc.iwe.models.Pergunta;
import com.udesc.iwe.service.PerguntaService;

@RestController
@RequestMapping("/api/perguntas")
public class PerguntaController {


    private final PerguntaService perguntaService;


    @Autowired
    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping
    public ResponseEntity<List<Pergunta>> listarTodasPerguntas() {
        List<Pergunta> perguntas = perguntaService.listarTodasPerguntas();
        return new ResponseEntity<>(perguntas, HttpStatus.OK);
    } //recuperar todas as perguntas
}

