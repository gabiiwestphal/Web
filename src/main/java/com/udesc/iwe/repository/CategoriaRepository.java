package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udesc.iwe.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	@Query(nativeQuery = true, value = "SELECT DISTINCT c.* FROM iwe.categoria c " +
	           "JOIN iwe.resposta r ON c.id_categoria = r.id_categoria " +
	           "WHERE r.id_resposta IN :arrayRespostas")
	    List<Categoria> findCategoriasByRespostas(@Param("arrayRespostas") List<Long> arrayRespostas);
	
	//retorna uma lista de categorias, associadas a uma resposta
}
