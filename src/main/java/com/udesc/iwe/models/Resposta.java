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


@Entity
@Table(name = "resposta")
public class Resposta {

	@Id
	@Column(name = "id_resposta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResposta;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@NotBlank
	@Column(name = "conteudo", length = 50)
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta", nullable = false)
	private Pergunta pergunta;
}
