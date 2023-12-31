package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.udesc.iwe.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM iwe.livro WHERE titulo = :titulo")
    List<Livro> findByTituloLivro(@Param("titulo") String titulo);
	
	//retorna lista de livros pelo titulo

    @Query(nativeQuery = true, value = "SELECT * FROM iwe.livro WHERE id_categoria = :idCategoria")
    List<Livro> findByCategoriaId(@Param("idCategoria") Long idCategoria);
    
    //retorna lista de livros com base no id_categoria

    @Query(nativeQuery = true, value = "SELECT * FROM iwe.livro")
    List<Livro> findAllLivros();
    
    //retorna todos os livros

}

