package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "cod_pessoa")
	private int id;

	public Pessoa(int id, String nome, String email, String username, String password, Boolean eAdmin,
			Boolean eConfiavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.eAdmin = eAdmin;
		this.eConfiavel = eConfiavel;
	}

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	@NotEmpty()
	@Length(min = 10, message = "Seu nome não pode ter menos que 10 caracteres.")
	private String nome;

	@NotEmpty()
	@Email(message = "Digite um Email válido.")
	private String email;

	@NotEmpty()
	@Length(min = 5, message = "Seu nome de usuario não pode ter menos que 5")
	private String username;

	@NotEmpty()
	@Length(min = 6, message = "Sua senha não pode ter menos que 6 caracteres.")
	private String password;

	private Boolean eAdmin = false;
	private Boolean eConfiavel = false;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Produto> produtos;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Comentario> comentarios;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Classificacao> classificacoes;

	public Boolean geteConfiavel() {
		return eConfiavel;
	}

	public void seteConfiavel(Boolean eConfiavel) {
		this.eConfiavel = eConfiavel;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean geteAdmin() {
		return eAdmin;
	}

	public void seteAdmin(Boolean eAdmin) {
		this.eAdmin = eAdmin;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
		result = prime * result + ((eAdmin == null) ? 0 : eAdmin.hashCode());
		result = prime * result + ((eConfiavel == null) ? 0 : eConfiavel.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Pessoa other = (Pessoa) obj;
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
		if (eAdmin == null) {
			if (other.eAdmin != null)
				return false;
		} else if (!eAdmin.equals(other.eAdmin))
			return false;
		if (eConfiavel == null) {
			if (other.eConfiavel != null)
				return false;
		} else if (!eConfiavel.equals(other.eConfiavel))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
