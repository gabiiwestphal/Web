package com.udesc.iwe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udesc.iwe.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ //entidade e tipo da chave primária
	
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
	
    @Query(nativeQuery = true, value = "SELECT * FROM iwe.usuario")
    List<Usuario> findAllUsuarios();
    
    //retorna todos os usuarios
    
    Optional<Usuario> findById(Long id);

}
