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

@Entity
@Table(name = "atributo")
public class Atributo implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "cod_atributo")
	private int id;
	private String nome;
	private String tipoDado;
	private Boolean status;
	
	@OneToMany(mappedBy="produto", fetch = FetchType.LAZY)
	private List<ValorAtributo> valorAtributos;
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_produto") 
	private TipoProduto tipoProduto;
}
