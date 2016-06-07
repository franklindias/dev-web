package model;

import java.util.Date;
import java.util.List;

public class Produto {
	private int id;
	private String nome;
	private String pagina;
	private Boolean status;
	private List<String> fotos;
	private Date ultimaModificacao;
	
	private List<ValorAtributo> valorAtributos;
	
	private TipoProduto tipoProduto;
	
	private Pessoa pessoa;
	
	private List<Comentario> comentarios;
	
	private List<Classificacao> classificacoes;
	
}
