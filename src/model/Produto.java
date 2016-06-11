package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "cod_produto")
	private int id;
	private String nome;
	private String pagina;
	private Boolean status;
	private Date ultimaModificacao;
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_produto", nullable=false) 
	private TipoProduto tipoProduto;
	
	@ManyToOne
	@JoinColumn(name = "cod_pessoa", nullable=false) 
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private List<ValorAtributo> valorAtributos;
	
	@OneToMany(mappedBy="produto", fetch = FetchType.LAZY)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy="produto", fetch = FetchType.LAZY)
	private List<Classificacao> classificacoes;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getUltimaModificacao() {
		return ultimaModificacao;
	}

	public void setUltimaModificacao(Date ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ValorAtributo> getValorAtributos() {
		return valorAtributos;
	}

	public void setValorAtributos(List<ValorAtributo> valorAtributos) {
		this.valorAtributos = valorAtributos;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Classificacao> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classificacoes == null) ? 0 : classificacoes.hashCode());
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pagina == null) ? 0 : pagina.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
		result = prime * result + ((ultimaModificacao == null) ? 0 : ultimaModificacao.hashCode());
		result = prime * result + ((valorAtributos == null) ? 0 : valorAtributos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (classificacoes == null) {
			if (other.classificacoes != null)
				return false;
		} else if (!classificacoes.equals(other.classificacoes))
			return false;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pagina == null) {
			if (other.pagina != null)
				return false;
		} else if (!pagina.equals(other.pagina))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoProduto == null) {
			if (other.tipoProduto != null)
				return false;
		} else if (!tipoProduto.equals(other.tipoProduto))
			return false;
		if (ultimaModificacao == null) {
			if (other.ultimaModificacao != null)
				return false;
		} else if (!ultimaModificacao.equals(other.ultimaModificacao))
			return false;
		if (valorAtributos == null) {
			if (other.valorAtributos != null)
				return false;
		} else if (!valorAtributos.equals(other.valorAtributos))
			return false;
		return true;
	}
	
}
