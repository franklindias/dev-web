package model;

import java.util.Date;

public class Denuncia {
	private String motivo;
	private String novoValor;
	private Date dataDenuncia;
	private Boolean status;
	
	//quem criou a denuncia
	private Pessoa pessoa;
	
	//o atributo que está sendo denunciando
	private ValorAtributo valorAtributo;
	
	
}
