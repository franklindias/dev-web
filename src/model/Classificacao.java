package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classificacao")
public class Classificacao implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "cod_classificacao")
	private int id;
	private int quantidadeEstralhas;
	private Date dataClassificacao;
	
	//produto que esta sendo classificado
	@ManyToOne
	@JoinColumn(name = "cod_produto") 
	private Produto produto;
	
	//pessoa que classificou o produto
	@ManyToOne
	@JoinColumn(name = "cod_pessoa") 
	private Pessoa pessoa;
	
}
