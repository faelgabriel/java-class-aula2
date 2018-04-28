package br.biblioteca.livros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;

	public Iterable<Livro> listaLivros() {
		return livroRepository.findAll();
	}

	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}

	public Livro findOne(Long id) {
		return livroRepository.findOne(id);
	}

	public void delete(Livro livro) {
		livroRepository.delete(livro);
	}
}
