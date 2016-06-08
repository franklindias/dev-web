package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_produto")
public class TipoProduto  implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "cod_tipo_produto")
	private int id;
	private String nome;
	private Boolean status;
	
	@OneToMany(mappedBy="tipo_produto", fetch = FetchType.LAZY)
	private List<Produto> produtos;
	
	@OneToMany(mappedBy="tipo_produto", fetch = FetchType.LAZY)
	private List<Atributo> atributos;
}
