package com.udesc.iwe.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pergunta")
	@JsonManagedReference(value = "respostasRef")
	private List<Resposta> respostas;
}
