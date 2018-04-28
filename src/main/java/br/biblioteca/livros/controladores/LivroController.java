package br.biblioteca.livros.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@GetMapping("/list")
	public ModelAndView livros() {

		Iterable<Livro> livros = livroService.listaLivros();
		return new ModelAndView("livros/list", "livros", livros);

	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Livro livro) {
		return "livros/form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(Livro livro) {
		livro = livroService.save(livro);
		return new ModelAndView("redirect:/livros/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = this.livroService.findOne(id);
		return new ModelAndView("livros/form", "livro", livro);
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Livro livro = this.livroService.findOne(id);
		this.livroService.delete(livro);
		return new ModelAndView("redirect:/livros/list");
	}


}
