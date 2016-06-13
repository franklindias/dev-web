package controller;

import dao.TipoProdutoDAO;
import model.Pessoa;
import model.TipoProduto;
import util.SessionUtil;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class TipoProdutoBean {

	private TipoProduto tipoProduto;
	private DataModel<TipoProduto> listaTipoProdutos;
	private Pessoa u;

	public TipoProdutoBean() {
		List<TipoProduto> lista = new TipoProdutoDAO().findAll();
		listaTipoProdutos = new ListDataModel<TipoProduto>(lista);
		tipoProduto = new TipoProduto();
	}

	public void cadastrar() {

		HttpSession sesison = new SessionUtil().getSession();

		u = (Pessoa) sesison.getAttribute("usuario-logado");

		tipoProduto.setStatus(u.geteAdmin());

		new TipoProdutoDAO().save(tipoProduto);
		List<TipoProduto> lista = new TipoProdutoDAO().findAll();
		listaTipoProdutos = new ListDataModel<TipoProduto>(lista);
		tipoProduto = new TipoProduto();
	}

	public void alterar() {
		new TipoProdutoDAO().alter(tipoProduto);
		List<TipoProduto> lista = new TipoProdutoDAO().findAll();
		listaTipoProdutos = new ListDataModel<TipoProduto>(lista);
		tipoProduto = new TipoProduto();
	}
	

	public void mudarStatus(TipoProduto tp) {
		tp.setStatus(!tp.getStatus());
		new TipoProdutoDAO().alter(tp);
		List<TipoProduto> lista = new TipoProdutoDAO().findAll();
		listaTipoProdutos = new ListDataModel<TipoProduto>(lista);
		tipoProduto = new TipoProduto();
	}

	public void excluir(TipoProduto tp) {
		new TipoProdutoDAO().delete(tp);
		List<TipoProduto> lista = new TipoProdutoDAO().findAll();
		listaTipoProdutos = new ListDataModel<TipoProduto>(lista);
		tipoProduto = new TipoProduto();
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public DataModel<TipoProduto> getListaTipoProdutos() {
		List<TipoProduto> lista = new TipoProdutoDAO().findAll();
		listaTipoProdutos = new ListDataModel<TipoProduto>(lista);
		return listaTipoProdutos;
	}
	
	public DataModel<TipoProduto> getListaTipoProdutosAtivos() {
		List<TipoProduto> lista = new TipoProdutoDAO().buscarAtivos();
		listaTipoProdutos = new ListDataModel<TipoProduto>(lista);
		return listaTipoProdutos;
	}

	public void setListaTipoProdutos(DataModel<TipoProduto> listaTipoProdutos) {
		this.listaTipoProdutos = listaTipoProdutos;
	}

}