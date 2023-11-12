package com.udesc.iwe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udesc.iwe.models.Curtido;
import com.udesc.iwe.models.Usuario;

public interface CurtidoRepository extends JpaRepository<Curtido, Long>{ // classe/entidade curtido e long é a chave primária

	@Query(nativeQuery = true, value = "SELECT * FROM iwe.curtido WHERE id_usuario = :idUsuario")
    Curtido findByUsuarioId(@Param("idUsuario") Long idUsuario); // especifica o tipo do valor que vai ser passado como parametro para a consulta
	    
	    //livros curtidos por um usuário pelo idUsuario.
	
    @Query(nativeQuery = true, value = "SELECT * FROM iwe.curtido")
    List<Curtido> findAllCurtidos();
    
    Curtido findByUsuario(Usuario usuario); 
    //curtido pelo objeto usuario.
    
    
}
