package com.udesc.iwe.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "curtido", schema = "iwe")
@Data
public class Curtido {
	
	@Id
	@Column(name = "id_curtido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurtido;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@ElementCollection
	@Column(name = "livros", columnDefinition = "json")
	private List<String> livros;


}
