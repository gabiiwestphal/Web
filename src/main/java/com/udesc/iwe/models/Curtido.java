package com.udesc.iwe.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "curtido")
@Data
public class Curtido {
	
	@Id
	@Column(name = "id_curtido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurtido;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", unique = true, nullable = false)
	private Usuario usuario;
	
	@Column(name = "livros", columnDefinition = "text[]") //ver se não é json 
	private List<String> livros;

}
