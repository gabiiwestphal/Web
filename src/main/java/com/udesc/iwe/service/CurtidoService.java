package com.udesc.iwe.service;


import org.springframework.stereotype.Service;

import com.udesc.iwe.models.Curtido;
import com.udesc.iwe.repository.CurtidoRepository;

@Service
public class CurtidoService {

	private final CurtidoRepository curtidoRepository;
	
	public CurtidoService(CurtidoRepository curtidoRepository) {
		this.curtidoRepository = curtidoRepository;
	}
	
	public Curtido listarLivrosCurtidosPorUsuario(Long idUsuario){
		return curtidoRepository.findByUsuarioId(idUsuario);
	}
}
