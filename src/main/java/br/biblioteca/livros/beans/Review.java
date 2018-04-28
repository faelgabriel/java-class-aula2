package br.biblioteca.livros.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "avaliacao")
	private Integer avaliacao;

	@Column(name = "comentario", nullable = true)
	private String comentario;

	@ManyToOne
	@JoinColumn(name = "livroId")
	private Livro livroId;

	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private Usuario usuarioId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Livro getLivroId() {
		return livroId;
	}

	public void setLivroId(Livro livroId) {
		this.livroId = livroId;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

}
