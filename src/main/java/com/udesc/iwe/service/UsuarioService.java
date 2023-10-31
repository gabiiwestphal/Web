package com.udesc.iwe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udesc.iwe.exception.AutenticacaoException;
import com.udesc.iwe.exception.UsuarioNaoEncontrado;
import com.udesc.iwe.exception.ValidarEmailException;
import com.udesc.iwe.models.Usuario;
import com.udesc.iwe.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository; //dependências
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(null);
		return usuarioRepository.save(usuario);
	}
	
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new AutenticacaoException("Usuário não encontrado.");
		}
		
		if (!usuario.get().getSenha().equals(senha)) {
			throw new AutenticacaoException("Senha inválida.");
		}
		return usuario.get();
	}
	
	public void validarEmail(String email) {
		boolean existe = usuarioRepository.existsByEmail(email);
		if(existe) {
			throw new ValidarEmailException("já existe um usuário cadastrado com este email");
		}
		
	}
	
	public void deletarUsuario(Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
	
	public Usuario atualizarUsuario(Long idUsuario, Usuario usuarioAtualizado) {
		Usuario usuarioExistente= usuarioRepository.findById(idUsuario).orElseThrow(() -> new UsuarioNaoEncontrado("Usuário não encontrado com o id: " + idUsuario));
		
		usuarioExistente.setNome(usuarioAtualizado.getNome());
		usuarioExistente.setCpf(usuarioAtualizado.getCpf());
		usuarioExistente.setEmail(usuarioAtualizado.getEmail());
		usuarioExistente.setSenha(usuarioAtualizado.getSenha());
		
		return usuarioRepository.save(usuarioExistente);
	}
	
	public Usuario buscarUsuarioPorId(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElseThrow(() -> new UsuarioNaoEncontrado("Usuário não encontrado com o Id: " + idUsuario));
	}
	
	public List<Usuario> listarTodosUsuarios(){
		return usuarioRepository.findAllUsuarios();
	}
	
}
