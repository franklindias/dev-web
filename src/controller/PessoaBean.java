package controller;

import dao.PessoaDAO;
import model.Pessoa;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class PessoaBean {

	private Pessoa pessoa;
	private DataModel<Pessoa> listaPessoas;

	public PessoaBean() {
		List<Pessoa> lista = new PessoaDAO().findAll();
		listaPessoas = new ListDataModel<Pessoa>(lista);
		pessoa = new Pessoa();
	}

	public void cadastrar() {
		pessoa.seteAdmin(false);
		new PessoaDAO().save(pessoa);
		List<Pessoa> lista = new PessoaDAO().findAll();
		listaPessoas = new ListDataModel<Pessoa>(lista);
		pessoa = new Pessoa();
	}

	public void alterar() {
		new PessoaDAO().alter(pessoa);
		List<Pessoa> lista = new PessoaDAO().findAll();
		listaPessoas = new ListDataModel<Pessoa>(lista);
		pessoa = new Pessoa();
	}

	public void excluir() {
		new PessoaDAO().delete(pessoa);
		List<Pessoa> lista = new PessoaDAO().findAll();
		listaPessoas = new ListDataModel<Pessoa>(lista);
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DataModel<Pessoa> getListaPessoas() {
		List<Pessoa> lista = new PessoaDAO().findAll();
		listaPessoas = new ListDataModel<Pessoa>(lista);
		return listaPessoas;
	}

	public void setListaPessoas(DataModel<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public void logar() {

	}

}