package model;

import java.io.Serializable;
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

@Entity
@Table(name = "valor_atributo")
public class ValorAtributo implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "cod_valor_atributo")
	private int id;
	
	private String valor;
	private Boolean status;
	private Date ultimaModificacao;
	
	@ManyToOne
	@JoinColumn(name = "cod_atributo") 
	private Atributo atributo;
	
	@ManyToOne
	@JoinColumn(name = "cod_produto") 
	private Produto produto;
	
	@OneToMany(mappedBy="valorAtributo", fetch = FetchType.LAZY)
	private List<Denuncia> denuncias;
}
