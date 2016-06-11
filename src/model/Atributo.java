package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.sound.midi.Sequence;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "atributo")
public class Atributo implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "cod_atributo")
	private int id;
	
	@NotEmpty
	@NotNull
	@Length(min=5, max=30)
	private String nome;
	@NotEmpty
	@NotNull
	@Length(min=5, max=30)
	private String tipoDado;
	private Boolean status;
	
	@OneToMany(mappedBy="produto", fetch = FetchType.LAZY)
	private List<ValorAtributo> valorAtributos;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "cod_tipo_produto", nullable=false) 
	private TipoProduto tipoProduto;

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

	public String getTipoDado() {
		return tipoDado;
	}

	public void setTipoDado(String tipoDado) {
		this.tipoDado = tipoDado;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<ValorAtributo> getValorAtributos() {
		return valorAtributos;
	}

	public void setValorAtributos(List<ValorAtributo> valorAtributos) {
		this.valorAtributos = valorAtributos;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoDado == null) ? 0 : tipoDado.hashCode());
		result = prime * result + ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
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
		Atributo other = (Atributo) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoDado == null) {
			if (other.tipoDado != null)
				return false;
		} else if (!tipoDado.equals(other.tipoDado))
			return false;
		if (tipoProduto == null) {
			if (other.tipoProduto != null)
				return false;
		} else if (!tipoProduto.equals(other.tipoProduto))
			return false;
		if (valorAtributos == null) {
			if (other.valorAtributos != null)
				return false;
		} else if (!valorAtributos.equals(other.valorAtributos))
			return false;
		return true;
	}
	
	
}
