package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "valor_atributo")
public class ValorAtributo implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "cod_valor_atributo")
	private int id;
	
	@NotNull
	@NotEmpty
	private String valor;
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "cod_atributo") 
	private Atributo atributo;
	
	public ValorAtributo(){
		
	}
	
	public ValorAtributo(String valor, Boolean status, Atributo atributo, Produto produto) {
		super();
		this.valor = valor;
		this.status = status;
		this.atributo = atributo;
		this.produto = produto;
	}

	@ManyToOne
	@JoinColumn(name = "cod_produto") 
	private Produto produto;
	
	//TALVEZ TIRAR
	@OneToMany(mappedBy="valorAtributo", fetch = FetchType.LAZY)
	private List<Denuncia> denuncias;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Denuncia> getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atributo == null) ? 0 : atributo.hashCode());
		result = prime * result + ((denuncias == null) ? 0 : denuncias.hashCode());
		result = prime * result + id;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		ValorAtributo other = (ValorAtributo) obj;
		if (atributo == null) {
			if (other.atributo != null)
				return false;
		} else if (!atributo.equals(other.atributo))
			return false;
		if (denuncias == null) {
			if (other.denuncias != null)
				return false;
		} else if (!denuncias.equals(other.denuncias))
			return false;
		if (id != other.id)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	
	
}
