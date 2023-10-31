package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udesc.iwe.models.Livro;
import com.udesc.iwe.models.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
	
    @Query(nativeQuery = true, value = "SELECT * FROM iwe.pergunta")
    List<Pergunta> findAllPerguntas();
    
    //retorna todas as perguntas

}
