package com.udesc.iwe.controller;

import java.util.List;

import com.udesc.iwe.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udesc.iwe.models.Categoria;
import com.udesc.iwe.models.Resposta;
import com.udesc.iwe.service.RespostaService;

@RestController
@RequestMapping("/api/respostas")
public class  RespostaController {


    private final RespostaService respostaService;


    @Autowired
    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }


    /*@PostMapping
    public ResponseEntity<Resposta> salvarResposta(@RequestBody Resposta resposta) {
        Resposta respostaSalva = respostaService.salvarResposta(resposta);
        return new ResponseEntity<>(respostaSalva, HttpStatus.CREATED);
    }*/
    @GetMapping("/buscar/{idResposta}")
    public ResponseEntity<Resposta> buscarRespostaPorId(@PathVariable Long idResposta) {
        Resposta resposta = respostaService.buscarRespostaPorId(idResposta);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    
    @GetMapping("/pergunta/{idPergunta}")
    public ResponseEntity<List<Resposta>> consultarRespostasPorIdPergunta(@PathVariable Long idPergunta) {
        List<Resposta> respostas = respostaService.consultarRespostasPorIdPergunta(idPergunta);
        return new ResponseEntity<>(respostas, HttpStatus.OK); //endpoint para obter respostas por idPergunta
    }


    @PostMapping("/processar")
    public ResponseEntity<Categoria> processarRespostas(@RequestBody List<Resposta> respostas) {
        Categoria categoriaMaisVotada = respostaService.calcularCategoriaMaisVotada(respostas);
        return new ResponseEntity<>(categoriaMaisVotada, HttpStatus.OK);
    } //Chama o método calcularCategoriaMaisVotada do respostaService, que recebe a lista de respostas e realiza o cálculo para determinar a categoria mais votada.
    //corpo contendo a lista de respostas, este método processa essas respostas e retorna a categoria mais votada como resposta.


    @GetMapping
    public ResponseEntity<List<Resposta>> listarTodasRespostas() {
        List<Resposta> respostas = respostaService.listarTodasRespostas();
        return new ResponseEntity<>(respostas, HttpStatus.OK);
    }
}
