package com.udesc.iwe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udesc.iwe.models.Curtido;

public interface CurtidoRepository extends JpaRepository<Curtido, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM iwe.curtido WHERE id_usuario = :usuarioId")
    Curtido findByUsuarioId(@Param("usuarioId") Long usuarioId);
	    
	    //livros curtidos por um usuário pelo idUsuario.
}
