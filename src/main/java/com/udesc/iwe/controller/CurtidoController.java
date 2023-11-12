package com.udesc.iwe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.udesc.iwe.models.Curtido;
import com.udesc.iwe.service.CurtidoService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/curtidos")
public class CurtidoController {


    private final CurtidoService curtidoService;


    @Autowired
    public CurtidoController(CurtidoService curtidoService) {
        this.curtidoService = curtidoService;
    }


    @GetMapping("/{idUsuario}")
    public ResponseEntity<Curtido> listarLivrosCurtidosPorUsuario(@PathVariable Long idUsuario) {
        Curtido curtido = curtidoService.listarLivrosCurtidosPorUsuario(idUsuario);
        return new ResponseEntity<>(curtido, HttpStatus.OK);
    }


    @PostMapping("/{idUsuario}/adicionar/{idLivro}")
    public ResponseEntity<Curtido> adicionarLivroAosCurtidos(
            @PathVariable Long idUsuario,
            @PathVariable Long idLivro
    ) {
        Curtido curtido = curtidoService.adicionarLivroAosCurtidos(idUsuario, idLivro);
        return new ResponseEntity<>(curtido, HttpStatus.OK);
    }


    @PostMapping("/{idUsuario}/remover/{idLivro}")
    public ResponseEntity<Curtido> removerLivroDosCurtidos(
            @PathVariable Long idUsuario,
            @PathVariable Long idLivro
    ) {
        Curtido curtido = curtidoService.removerLivroDosCurtidos(idUsuario, idLivro);
        return new ResponseEntity<>(curtido, HttpStatus.OK);
    }
}

