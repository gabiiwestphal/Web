package com.udesc.iwe.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udesc.iwe.models.Curtido;
import com.udesc.iwe.models.Usuario;
import com.udesc.iwe.repository.CurtidoRepository;

@Service
public class CurtidoService {

	    private final CurtidoRepository curtidoRepository;
	    private final UsuarioService usuarioService;


	    @Autowired
	    public CurtidoService(CurtidoRepository curtidoRepository, UsuarioService usuarioService) {
	        this.curtidoRepository = curtidoRepository;
	        this.usuarioService = usuarioService;
	    }


	    public Curtido listarLivrosCurtidosPorUsuario(Long idUsuario) {
	        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
	        return curtidoRepository.findByUsuario(usuario);
	    }


	    public Curtido adicionarLivroAosCurtidos(Long idUsuario, Long idLivro) { //adiciona um livro aos curtidos do usuário.
	        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
	        Curtido curtido = curtidoRepository.findByUsuario(usuario);


	        if (curtido == null) {//se o usuário não tem um curtido, cria uma nova intância e adiciona o livro na lista.
	            curtido = new Curtido();
	            curtido.setUsuario(usuario);
	            curtido.setLivros(new ArrayList<>()); // Inicializa a lista se for nula
	        }


	        List<String> livros = curtido.getLivros();
	        livros.add(String.valueOf(idLivro));
	        curtido.setLivros(livros);


	        return curtidoRepository.save(curtido);
	    }


	    public Curtido removerLivroDosCurtidos(Long idUsuario, Long idLivro) {//remove livro dos curtidos de um usuario.
	        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
	        Curtido curtido = curtidoRepository.findByUsuario(usuario);


	        if (curtido != null) { //verifica se o usuario tem curtido, se não tiver, retorna o estado atual do objeto curtido
	            List<String> livros = curtido.getLivros();


	            if (livros != null) {//se tiver o livro na lista, remove e salva.
	                livros.remove(String.valueOf(idLivro));
	                curtido.setLivros(livros);
	                return curtidoRepository.save(curtido);
	            }
	        }


	        return curtido;
	    }
	}

