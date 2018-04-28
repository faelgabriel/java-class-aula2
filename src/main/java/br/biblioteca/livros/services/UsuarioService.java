package br.biblioteca.livros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Iterable<Usuario> listaUsuarios() {
		return usuarioRepository.findAll();
	}
}
