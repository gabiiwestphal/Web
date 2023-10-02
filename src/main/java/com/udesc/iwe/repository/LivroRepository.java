package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.udesc.iwe.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM livro WHERE nome = :nomeLivro")
    List<Livro> findByNomeLivro(@Param("nomeLivro") String nomeLivro);
	
	//retorna lista de livros pelo nome

    @Query(nativeQuery = true, value = "SELECT * FROM livro WHERE id_categoria = :idCategoria")
    List<Livro> findByCategoriaId(@Param("idCategoria") Long idCategoria);
    
    //retorna lista de livros com base no id_categoria

    @Query(nativeQuery = true, value = "SELECT * FROM livro")
    List<Livro> findAllLivros();
    
    //retorna todos os livros
}

