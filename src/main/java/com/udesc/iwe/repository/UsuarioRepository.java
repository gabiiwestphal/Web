package com.udesc.iwe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udesc.iwe.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ //entidade e tipo da chave primária

}
