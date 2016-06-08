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
@Table(name = "denuncia")
public class Denuncia implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "cod_denuncia")
	private int id;
	
	private String motivo;
	private String novoValor;
	private Date dataDenuncia;
	private Boolean status;
	
	//quem criou a denuncia
	@ManyToOne
	@JoinColumn(name = "cod_pessoa") 
	private Pessoa pessoa;
	
	//o atributo que está sendo denunciando
	@ManyToOne
	@JoinColumn(name = "cod_valor_atributo") 
	private ValorAtributo valorAtributo;
	
	
}
