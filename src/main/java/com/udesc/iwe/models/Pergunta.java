package com.udesc.iwe.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "pergunta", schema = "iwe")
@Data
public class Pergunta {

	@Id
	@Column(name = "id_pergunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPergunta;
	
	@NotBlank
	@Column(name = "conteudo_pergunta", nullable = false)
	private String conteudoPergunta;
}
