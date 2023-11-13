package com.udesc.iwe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.udesc.iwe.models.Categoria;
import com.udesc.iwe.service.CategoriaService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {
        List<Categoria> categorias = categoriaService.listarTodasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }    

}
