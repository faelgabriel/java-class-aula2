package br.biblioteca.livros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;

	public Iterable<Autor> listaAutores() {
		return autorRepository.findAll();
	}
}
