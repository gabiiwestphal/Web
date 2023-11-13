package com.udesc.iwe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.udesc.iwe.models.Livro;
import com.udesc.iwe.service.LivroService;


@RestController
@RequestMapping("/livros")
public class LivroController {
	
    private final LivroService livroService;
    
    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodosLivros() {
        List<Livro> livros = livroService.listarTodosLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.salvarLivro(livro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{idLivro}")
    public ResponseEntity<Livro> buscarLivroPeloId(@PathVariable Long idLivro) {
        Livro livro = livroService.buscarLivroPeloId(idLivro);
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<Livro>> buscarLivrosPorCategoria(@PathVariable Long idCategoria) {
        List<Livro> livros = livroService.buscarLivrosPorCategoria(idCategoria);
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Livro>> buscarLivroPeloTitulo(@PathVariable String titulo) {
        List<Livro> livros = livroService.buscarLivroPeloTitulo(titulo);
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @DeleteMapping("/{idLivro}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long idLivro) {
        livroService.deletarLivro(idLivro);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idLivro}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long idLivro, @RequestBody Livro livroAtualizado) {
        Livro livroAtualizadoResult = livroService.atualizarLivro(idLivro, livroAtualizado);
        return new ResponseEntity<>(livroAtualizadoResult, HttpStatus.OK);
    }

}
