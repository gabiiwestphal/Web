package com.udesc.iwe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udesc.iwe.exception.LivroNaoEncontrado;
import com.udesc.iwe.models.Livro;
import com.udesc.iwe.repository.LivroRepository;

@Service
public class LivroService {
	
	private final LivroRepository livroRepository;
	
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	//listar livros
	public List<Livro> listarTodosLivros(){
		return livroRepository.findAll();
	}
	
	//salvar livros
	public Livro salvarLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	//achar livro pelo id
	public Livro buscarLivroPeloId(Long idLivro) {
		return livroRepository.findById(idLivro).orElseThrow(() -> new LivroNaoEncontrado("Livro não encontrado com o Id: " + idLivro));
	}
	
	//achar o livro pela categoria
	public List<Livro> buscarLivrosPorCategoria(Long idCategoria){
		return livroRepository.findByCategoriaId(idCategoria);
	}
	
	//achar livro pelo nome
	public List<Livro> buscarLivroPeloTitulo(String titulo){
		return livroRepository.findByTituloLivro(titulo);
	}
	
	//deletar livro
	public void deletarLivro(Long idLivro) {
		livroRepository.deleteById(idLivro);
	}
	
	public Livro atualizarLivro(Long idLivro, Livro livroAtualizado) {
        Livro livroExistente = livroRepository.findById(idLivro).orElseThrow(() -> new LivroNaoEncontrado("Livro não encontrado com o id: " + idLivro));

        if (livroExistente != null) {
    
            livroExistente.setTitulo(livroAtualizado.getTitulo());
            livroExistente.setCategoria(livroAtualizado.getCategoria());
            livroExistente.setDescricao(livroAtualizado.getDescricao());
            livroExistente.setAutor(livroAtualizado.getAutor());
            livroExistente.setPagina(livroAtualizado.getPagina());
            livroExistente.setClassificacao(livroAtualizado.getClassificacao());
            livroExistente.setAvaliacao(livroAtualizado.getAvaliacao());
            livroExistente.setSubtitulo(livroAtualizado.getSubtitulo());
            livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());


            return livroRepository.save(livroExistente);
        }

        return null; // Retorne null se o livro não for encontrado
    }

}
