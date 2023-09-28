package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.udesc.iwe.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT l FROM Livro l WHERE l.nome = :nome")
    List<Livro> findByNome(@Param("nome") String nome);
	//achar livro pelo nome
	
	@Query("SELECT l FROM Livro l WHERE l.categoria.nome = :nomeCategoria")
    List<Livro> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);
	//achar livro pela categoria
	
	@Query("SELECT l FROM Livro l")
    List<Livro> findAllLivros();
	//achar todos os livros sem filtro
}
