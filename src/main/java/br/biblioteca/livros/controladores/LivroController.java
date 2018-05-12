package br.biblioteca.livros.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.services.LivroService;
import br.biblioteca.livros.util.FileSaver;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@Autowired
	private FileSaver fileSaver;

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping("/list")
	public ModelAndView livros() {

		Iterable<Livro> livros = livroService.listaLivros();
		return new ModelAndView("livros/list", "livros", livros);

	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/form");
		Iterable<Autor> autores = autorRepository.findAll();
		modelAndView.addObject("autores", autores);
		return modelAndView;
	}

	// @GetMapping("/novo")
	// public String createForm(@ModelAttribute Livro livro) {
	// return "livros/form";
	// }

	@PostMapping(params = "form")
	public ModelAndView create(@RequestParam("capaUrl") MultipartFile capaUrl,
			@ModelAttribute("livro") @Valid Livro livro, BindingResult bindingResult, Model model) {

		if (livro.getId() != null) {
			if (capaUrl.getOriginalFilename().length() > 0) {
				incluiCapa(capaUrl, livro, model);
			}
		} else {
			if (capaUrl.getOriginalFilename().equals("")) {
				model.addAttribute("capa", "A capa não pode ser vazia");
			} else {
				incluiCapa(capaUrl, livro, model);
			}
		}

		if (bindingResult.hasErrors() || model.containsAttribute("message")) {
			Iterable<Autor> autores = autorRepository.findAll();
			return new ModelAndView("livro/form", "autores", autores);
		}
		// if (bindingResult.hasErrors()) {
		// return new ModelAndView("livros/form");
		// }

		livro = livroService.save(livro);
		return new ModelAndView("redirect:/livros/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = this.livroService.findOne(id);
		Iterable<Autor> autores = autorRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("livros/form");
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}

	// @GetMapping("/alterar/{id}")
	// public ModelAndView alterar(@PathVariable("id") Long id) {
	// Livro livro = this.livroService.findOne(id);
	// return new ModelAndView("livros/form", "livro", livro);
	// }

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Livro livro = this.livroService.findOne(id);
		this.livroService.delete(livro);
		return new ModelAndView("redirect:/livros/list");
	}

	private void incluiCapa(MultipartFile capaUrl, Livro livro, Model model) {
		if (capaUrl.getContentType().equals("image/jpeg")) {
			String webPath = fileSaver.write("uploaded-images", capaUrl);
			livro.setCapa(webPath);
		} else {
			model.addAttribute("capa", "Arquivo em formato errado. Permitido apenas jpg");
		}
	}

}
