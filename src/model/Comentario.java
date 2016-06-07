package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "cod_comentario")
	private int id;
	
	private String texto;
	
	//quem criou o comentario
	@ManyToOne
	@JoinColumn(name = "cod_pessoa") 
	private Pessoa pessoa;
	
	//o produto que esta sendo comentado
	@ManyToOne
	@JoinColumn(name = "cod_produto") 
	private Produto produto;
}
