package com.udesc.iwe.service;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udesc.iwe.models.Curtido;
import com.udesc.iwe.models.Livro;
import com.udesc.iwe.repository.CurtidoRepository;
import com.udesc.iwe.repository.LivroRepository;

@Service
public class CurtidoService {

	private final CurtidoRepository curtidoRepository;
	private final LivroRepository livroRepository;
	
	public CurtidoService(CurtidoRepository curtidoRepository, LivroRepository livroRepository) {
		this.curtidoRepository = curtidoRepository;
		this.livroRepository = livroRepository;
	}
	
	public Curtido listarLivrosCurtidosPorUsuario(Long idUsuario){
		return curtidoRepository.findByUsuarioId(idUsuario);
	}
}
