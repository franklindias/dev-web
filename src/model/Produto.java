package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "cod_produto")
	private int id;
	private String nome;
	private String pagina;
	private Boolean status;
	private List<String> fotos;
	private Date ultimaModificacao;
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_produto") 
	private TipoProduto tipoProduto;
	
	@ManyToOne
	@JoinColumn(name = "cod_pessoa") 
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private List<ValorAtributo> valorAtributos;
	
	@OneToMany(mappedBy="produto", fetch = FetchType.LAZY)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy="produto", fetch = FetchType.LAZY)
	private List<Classificacao> classificacoes;
	
}
