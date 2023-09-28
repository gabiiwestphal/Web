package com.udesc.iwe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udesc.iwe.models.Curtido;

public interface CurtidoRepository extends JpaRepository<Curtido, Long>{

	@Query("SELECT u.nome AS nomeUsuario, c.idCurtido, l.nome AS nomeLivro " +
	           "FROM Usuario u " +
	           "JOIN Curtido c ON c.usuario.idUsuario = u.idUsuario " +
	           "LEFT JOIN Livro l ON l.idLivro IN " +
	           "(SELECT json_array_elements_text(c.livros->'id')::bigint) " +
	           "WHERE u.idUsuario = :userId")
	    List<Object[]> findCurtidosByUsuarioId(@Param("userId") Long userId);
	    
	    //livros curtidos por um usuário pelo idUsuario.
}
