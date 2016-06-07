package model;

import java.util.List;

public class Pessoa {
	
	private int id;
	private String nome;
	private String email;
	private String username;
	private String password;
	private Boolean e_admin;
	
	private List<Produto> produtos;
	
	private List<Comentario> comentarios;
	
	private List<Classificacao> classificacoes;
	
}
