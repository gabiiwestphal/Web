package com.udesc.iwe.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udesc.iwe.models.Curtido;
import com.udesc.iwe.models.Usuario;
import com.udesc.iwe.repository.CurtidoRepository;

@Service
public class CurtidoService {

	private final CurtidoRepository curtidoRepository;
    private final UsuarioService usuarioService;

    @Autowired
    public CurtidoService(CurtidoRepository curtidoRepository, UsuarioService usuarioService) {
        this.curtidoRepository = curtidoRepository;
        this.usuarioService = usuarioService;
    }

    public Curtido listarLivrosCurtidosPorUsuario(Long idUsuario) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        return curtidoRepository.findByUsuarioId(idUsuario);
    }

    public Curtido adicionarLivroAosCurtidos(Long idUsuario, Long idLivro) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        Curtido curtido = curtidoRepository.findByUsuarioId(idUsuario);

        if (curtido == null) {
            curtido = new Curtido();
            curtido.setUsuario(usuario);
            curtido.setLivros(new String[0]);
        }

        String[] livros = curtido.getLivros();
        String[] newLivros = new String[livros.length + 1];
        System.arraycopy(livros, 0, newLivros, 0, livros.length);
        newLivros[livros.length] = String.valueOf(idLivro);
        curtido.setLivros(newLivros);

        return curtidoRepository.save(curtido);
    }

    public Curtido removerLivroDosCurtidos(Long idUsuario, Long idLivro) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        Curtido curtido = curtidoRepository.findByUsuarioId(idUsuario);

        if (curtido != null) {
            String[] livros = curtido.getLivros();

            if (livros != null) {
                List<String> livroList = new ArrayList<>(Arrays.asList(livros));
                livroList.remove(String.valueOf(idLivro));
                curtido.setLivros(livroList.toArray(new String[0]));
                return curtidoRepository.save(curtido);
            }
        }

        return curtido;
    }

}
