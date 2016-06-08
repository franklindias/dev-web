package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "cod_pessoa")
	private int id;
	
	private String nome;
	private String email;
	private String username;
	private String password;
	private Boolean eAdmin;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Produto> produtos;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Classificacao> classificacoes;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Admin admin;
	
}
