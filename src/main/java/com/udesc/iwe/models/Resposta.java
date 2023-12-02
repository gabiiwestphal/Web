package com.udesc.iwe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "resposta", schema = "iwe")
public class Resposta {

	@Id
	@Column(name = "id_resposta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResposta;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@NotBlank
	@Column(name = "conteudo", length = 250)
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta", nullable = false)
	private Pergunta pergunta;
}
