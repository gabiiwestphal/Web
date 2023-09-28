package com.udesc.iwe.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "livro", schema = "iwe")
@Data
public class Livro {
	
	@Id
	@Column(name= "id_livro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivro;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@NotBlank
	@Column(name= "nome", nullable = false)
	private String nome;

}
