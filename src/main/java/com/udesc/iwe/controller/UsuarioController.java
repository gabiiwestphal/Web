package com.udesc.iwe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.udesc.iwe.models.Usuario;
import com.udesc.iwe.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	    private final UsuarioService usuarioService;

	    @Autowired
	    public UsuarioController(UsuarioService usuarioService) {
	        this.usuarioService = usuarioService;
	    }

	    @PostMapping("/cadastrar")
	    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
	        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
	        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
	    }

	    @PostMapping("/autenticar")
	    public ResponseEntity<Usuario> autenticarUsuario(@RequestBody Usuario autenticacaoRequest) {
	        Usuario usuario = usuarioService.autenticar(autenticacaoRequest.getEmail(), autenticacaoRequest.getSenha());
	        return new ResponseEntity<>(usuario, HttpStatus.OK);
	    }

	    @GetMapping("/{idUsuario}")
	    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long idUsuario) {
	        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
	        return new ResponseEntity<>(usuario, HttpStatus.OK);
	    }

	    @GetMapping("/listar")
	    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
	        List<Usuario> usuarios = usuarioService.listarTodosUsuarios();
	        return new ResponseEntity<>(usuarios, HttpStatus.OK);
	    }

	    @PutMapping("/{idUsuario}")
	    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long idUsuario, @RequestBody Usuario usuarioAtualizado) {
	        Usuario usuarioAtualizadoResult = usuarioService.atualizarUsuario(idUsuario, usuarioAtualizado);
	        return new ResponseEntity<>(usuarioAtualizadoResult, HttpStatus.OK);
	    }

	    @DeleteMapping("/{idUsuario}")
	    public ResponseEntity<Void> deletarUsuario(@PathVariable Long idUsuario) {
	        usuarioService.deletarUsuario(idUsuario);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}

