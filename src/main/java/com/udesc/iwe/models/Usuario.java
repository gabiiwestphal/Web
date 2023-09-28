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
@Table(name = "usuario", schema = "iwe")
@Data //get, set, toString e construtor já prontos
public class Usuario {

	@Id //chave primaria
	@Column(name= "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //o id é serial, auto incremento
	private Long id_usuario;
	
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
