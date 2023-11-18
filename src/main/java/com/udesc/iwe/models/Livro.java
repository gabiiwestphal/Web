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
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "livro", schema = "iwe")
@Data
public class Livro {
	
	@Id
	@Column(name= "id_livro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivro;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@NotBlank
	@Column(name= "titulo", nullable = false)
	private String titulo;
	
	@NotBlank
	@Column(name= "descricao", nullable = false)
	private String descricao;
	
	@NotBlank
    @Column(name = "autor", nullable = false)
    private String autor;

	@NotNull
    @Column(name = "pagina")
    private Integer pagina;

    @Column(name = "classificacao")
    private Double classificacao;

    @Column(name = "avaliacao")
    private Integer avaliacao;

	@NotBlank
    @Column(name = "subtitulo")
    private String subtitulo;

	@NotBlank
    @Column(name = "ano_publicacao")
    private String anoPublicacao;
	
	
}
