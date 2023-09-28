package com.udesc.iwe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udesc.iwe.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	//encontrar a categoria com base no id-final do quiz.
}
