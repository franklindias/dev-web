package controller;

import dao.ProdutoDAO;
import dao.TipoProdutoDAO;
import dao.ValorAtributoDAO;
import model.Atributo;
import model.Pessoa;
import model.Produto;
import model.ValorAtributo;
import controller.AtributoBean;
import util.SessionUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private DataModel<Produto> listaProdutos;
	private DataModel<Atributo> listaAtributos;

	private ArrayList<ValorAtributo> valorAtributos = new ArrayList<ValorAtributo>();

	private Pessoa u;
	private int idProduto;
	private int idTipoProduto = 1;
	private ValorAtributo va;

	public ProdutoBean() {
		List<Produto> lista = new ProdutoDAO().findAll();
		listaProdutos = new ListDataModel<Produto>(lista);
		setListaAtributos(new AtributoBean().getListaAtributosByTipoProduto(idTipoProduto));
		setIdTipoProduto(new TipoProdutoBean().getListaTipoProdutosAtivos().getRowData().getId());
		
		produto = new Produto();
		
		loadValorAtributos();

	}

	public String refresh() {
		
		setListaAtributos(new AtributoBean().getListaAtributosByTipoProduto(idTipoProduto));

		loadValorAtributos();

		return null;
	}

	public void loadValorAtributos() {
		
		valorAtributos.clear();
		
		HttpSession sesison = new SessionUtil().getSession();

		u = (Pessoa) sesison.getAttribute("usuario-logado");
		
		for (Atributo at : new AtributoBean().getListaAtributosByTipoProduto(idTipoProduto)) {
			
			va = new ValorAtributo(null, u.geteAdmin(), at, produto);
			valorAtributos.add(va);

		}

	}

	public void cadastrar() {

		HttpSession sesison = new SessionUtil().getSession();

		u = (Pessoa) sesison.getAttribute("usuario-logado");

		// usuario que está cadastrando
		produto.setPessoa(u);
		// tipo de produto
		produto.setTipoProduto(TipoProdutoDAO.buscarPorId(idProduto));
		// status
		produto.setStatus(u.geteAdmin());
		
		produto.setValorAtributos(valorAtributos);
		
		produto.setTipoProduto(TipoProdutoDAO.buscarPorId(idTipoProduto));

		new ProdutoDAO().save(produto);
		List<Produto> lista = new ProdutoDAO().findAll();
		listaProdutos = new ListDataModel<Produto>(lista);
		
		produto = new Produto();
		
		loadValorAtributos();
		
		//for (ValorAtributo va : valorAtributos) {
		//	new ValorAtributoDAO().save(va);
		//}
	}

	public void alterar() {
		new ProdutoDAO().alter(produto);
		List<Produto> lista = new ProdutoDAO().findAll();
		listaProdutos = new ListDataModel<Produto>(lista);
		produto = new Produto();
	}

	public void mudarStatus(Produto at) {
		at.setStatus(!at.getStatus());
		new ProdutoDAO().alter(at);
		List<Produto> lista = new ProdutoDAO().findAll();
		listaProdutos = new ListDataModel<Produto>(lista);
		produto = new Produto();
	}

	public void excluir(Produto tp) {
		new ProdutoDAO().delete(tp);
		List<Produto> lista = new ProdutoDAO().findAll();
		listaProdutos = new ListDataModel<Produto>(lista);
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DataModel<Produto> getListaProdutos() {
		List<Produto> lista = new ProdutoDAO().findAll();
		listaProdutos = new ListDataModel<Produto>(lista);
		return listaProdutos;
	}

	public void setListaProdutos(DataModel<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public DataModel<Atributo> getListaAtributos() {
		return listaAtributos;
	}

	public void setListaAtributos(DataModel<Atributo> listaAtributos) {
		this.listaAtributos = listaAtributos;
	}

	public ArrayList<ValorAtributo> getValorAtributos() {
		return valorAtributos;
	}

	public void setValorAtributos(ArrayList<ValorAtributo> valorAtributos) {
		this.valorAtributos = valorAtributos;
	}

	public int getIdTipoProduto() {
		return idTipoProduto;
	}

	public void setIdTipoProduto(int idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

}