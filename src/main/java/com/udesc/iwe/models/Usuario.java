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
@Table(name = "usuario", schema = "iwe")
@Data //get, set, toString e construtor já prontos
public class Usuario {

	@Id //chave primaria
	@Column(name= "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //o id é serial, auto incremento
	private Long idUsuario;
	
	@NotBlank
	@Column(name= "cpf", unique = true, nullable = false)
	private String cpf;
	
	@NotBlank
	@Column(name= "nome", nullable = false)
	private String nome;
	
	@NotBlank
	@Column(name= "email", unique = true, nullable = false)
	private String email;

	@NotBlank
	@Column(name= "senha", nullable = false)
	private String senha;

}
