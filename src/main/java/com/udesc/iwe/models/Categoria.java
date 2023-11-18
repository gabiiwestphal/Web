package com.udesc.iwe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "categoria", schema = "iwe")
@Data
public class Categoria {

	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotBlank
	@Column(name = "nome", nullable = false)
	private String nome;
}
