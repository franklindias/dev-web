package model;

import java.util.Date;
import java.util.List;

public class ValorAtributo {
	
	private int id;
	private String valor;
	private Boolean status;
	private Date ultimaModificacao;
	
	private Atributo atributo;
	private Produto produto;
	
	private List<Denuncia> denuncias;
}
