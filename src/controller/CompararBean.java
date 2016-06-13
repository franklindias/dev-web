package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.ProdutoDAO;
import dao.TipoProdutoDAO;
import model.Produto;
import model.TipoProduto;

@ManagedBean(name = "compararBean")
@SessionScoped
public class CompararBean {

	private int p1 = 0;
	private int p2 = 0;
	private int tipoProdutoId = 0;
	private DataModel<Produto> produtoList;

	public CompararBean() {

	}

	public String refresh() {

		return null;
	}

	public DataModel<Produto> buscarProdutos() {

		List<Produto> lista = new ProdutoDAO().buscarProdutoPorTipoProdutoId(tipoProdutoId);
		produtoList = new ListDataModel<Produto>(lista);
		return produtoList;
	}

	public int getTipoProdutoId() {
		return tipoProdutoId;
	}

	public void setTipoProdutoId(int tipoProdutoId) {
		this.tipoProdutoId = tipoProdutoId;
	}

	public DataModel<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(DataModel<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	public int getTipoProduto() {
		return tipoProdutoId;
	}

	public void setTipoProduto(int tipoProdutoId) {
		this.tipoProdutoId = tipoProdutoId;
	}

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

	

}
