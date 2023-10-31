package com.udesc.iwe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udesc.iwe.models.Categoria;
import com.udesc.iwe.models.Resposta;
import com.udesc.iwe.repository.RespostaRepository;

@Service
public class RespostaService {

	private final RespostaRepository respostaRepository;
	
	@Autowired
	public RespostaService(RespostaRepository respostaRepository) {
		this.respostaRepository = respostaRepository;
	}
	
	public Resposta salvarResposta(Resposta resposta) {
		return respostaRepository.save(resposta);
	}
	
	//consultar respostas por idPergunta
	public List<Resposta> consultarRespostasPorIdPergunta(Long idPergunta){
		return respostaRepository.findRespostasByPerguntaId(idPergunta);
	}
	
	//cálculo da categoria mais votada com base nas respostas 
	/*public Categoria calcularCategoriaMaisVotada(List<Resposta> respostas) {
		
		Map<Categoria, Integer> contagemCategorias = new HashMap<>();
		Categoria categoriaMaisVotada = null;
		int contagemMaxima = 0;
		
		for(Resposta resposta: respostas) {
			Categoria categoria = resposta.getCategoria(); //obtém categoria associada a essa resposta
			int contagem = contagemCategorias.getOrDefault(categoria, 0) + 1; //verifica se já está no mapa
			contagemCategorias.put(categoria, contagem);
			
			if(contagem > contagemMaxima) {
				contagemMaxima = contagem;
				categoriaMaisVotada = categoria;
			}
		}
		return categoriaMaisVotada;
	}*/
}
