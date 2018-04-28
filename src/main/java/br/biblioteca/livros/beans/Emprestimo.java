package br.biblioteca.livros.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo {
	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dataEmprestimo;

	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;

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

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
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
