package com.udesc.iwe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udesc.iwe.models.Categoria;
import com.udesc.iwe.repository.CategoriaRepository;

@Service
public class CategoriaService {

private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<Categoria> listarTodasCategorias(){
		return categoriaRepository.findAll();
	}
	
}
