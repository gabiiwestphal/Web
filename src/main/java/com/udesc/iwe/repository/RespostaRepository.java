package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udesc.iwe.models.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long>{

	@Query(nativeQuery = true, value = "SELECT r.* FROM iwe.resposta r " +
	           "WHERE r.id_pergunta = :idPergunta")
	    List<Resposta> findRespostasByPerguntaId(@Param("idPergunta") Long idPergunta);
	
	    //retorna uma lista de respostas associadas a uma pergunta, pelo id_pergunta
}
