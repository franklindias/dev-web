package controller;

import dao.AtributoDAO;
import dao.TipoProdutoDAO;
import model.Pessoa;
import model.Atributo;
import util.SessionUtil;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class AtributoBean {

	private Atributo atributo;
	private DataModel<Atributo> listaAtributos;
	private Pessoa u;
	private int idProduto;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public AtributoBean() {
		List<Atributo> lista = new AtributoDAO().findAll();
		listaAtributos = new ListDataModel<Atributo>(lista);
		atributo = new Atributo();
	}

	public void cadastrar() {
		
		HttpSession sesison = new SessionUtil().getSession();

		u = (Pessoa) sesison.getAttribute("usuario-logado");
		
		atributo.setTipoProduto(TipoProdutoDAO.buscarPorId(idProduto));
		atributo.setStatus(u.geteAdmin());
		
		new AtributoDAO().save(atributo);
		List<Atributo> lista = new AtributoDAO().findAll();
		listaAtributos = new ListDataModel<Atributo>(lista);
		atributo = new Atributo();
	}

	public void alterar() {
		new AtributoDAO().alter(atributo);
		List<Atributo> lista = new AtributoDAO().findAll();
		listaAtributos = new ListDataModel<Atributo>(lista);
		atributo = new Atributo();
	}

	public void mudarStatus(Atributo at) {
		at.setStatus(!at.getStatus());
		new AtributoDAO().alter(at);
		List<Atributo> lista = new AtributoDAO().findAll();
		listaAtributos = new ListDataModel<Atributo>(lista);
		atributo = new Atributo();
	}

	public void excluir(Atributo tp) {
		new AtributoDAO().delete(tp);
		List<Atributo> lista = new AtributoDAO().findAll();
		listaAtributos = new ListDataModel<Atributo>(lista);
		atributo = new Atributo();
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public DataModel<Atributo> getListaAtributos() {
		List<Atributo> lista = new AtributoDAO().findAll();
		listaAtributos = new ListDataModel<Atributo>(lista);
		return listaAtributos;
	}

	public void setListaAtributos(DataModel<Atributo> listaAtributos) {
		this.listaAtributos = listaAtributos;
	}

}