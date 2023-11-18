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
