package com.udesc.iwe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udesc.iwe.models.Pergunta;
import com.udesc.iwe.repository.PerguntaRepository;


@Service
public class PerguntaService {

private final PerguntaRepository perguntaRepository;
	
	@Autowired
	public PerguntaService(PerguntaRepository perguntaRepository) {
		this.perguntaRepository = perguntaRepository;
	}
	
	public List<Pergunta> listarTodasPerguntas(){
		return perguntaRepository.findAllPerguntas();
	}
}
