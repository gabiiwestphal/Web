package com.udesc.iwe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udesc.iwe.models.Curtido;

public interface CurtidoRepository extends JpaRepository<Curtido, Long>{ // classe/entidade curtido e long é a chave primária

	@Query(nativeQuery = true, value = "SELECT * FROM iwe.curtido WHERE id_usuario = :idUsuario")
    Curtido findByUsuarioId(@Param("idUsuario") Long idUsuario); // especifica o tipo do valor que vai ser passado como parametro para a consulta
	    
	    //livros curtidos por um usuário pelo idUsuario.
}
