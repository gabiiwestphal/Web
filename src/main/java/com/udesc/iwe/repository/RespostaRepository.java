package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udesc.iwe.models.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long>{

	@Query("SELECT r.idResposta, r.conteudo, c.nome, r.pergunta.idPergunta " +
	           "FROM Resposta r " +
	           "LEFT JOIN r.categoria c " +
	           "WHERE r.pergunta.idPergunta = :perguntaId")
	    List<Object[]> findRespostasByPerguntaId(@Param("perguntaId") Long perguntaId);
	    
	    //respostas de uma pergunta pelo idPergunta
}
