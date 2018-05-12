package br.biblioteca.livros.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "Titulo cannot be empty")
	@Size(min = 2, max = 100, message = "O tamanho deve ser entre 2 a 100 caracteres")
	@Column(name = "titulo", nullable = true)
	private String titulo;

	@Column(name = "foto", nullable = true)
	private String foto;

	@NotNull(message = "Quantidade cannot be empty")
	@Min(value = 10, message = "valor mínimo é 10 páginas")
	@Column(name = "quantidade")
	private Integer quantidade;

	@ManyToOne
	private Autor autorId;

	@OneToMany(mappedBy = "livroId")
	private List<Emprestimo> emprestimos = new ArrayList<>();

	@OneToMany(mappedBy = "livroId")
	private List<Review> reviews = new ArrayList<>();

	private String capa;

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Autor getAutorId() {
		return autorId;
	}

	public void setAutorId(Autor autorId) {
		this.autorId = autorId;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
