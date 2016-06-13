package dao;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.hibernate.Query;

import model.Atributo;
import model.Produto;
import model.TipoProduto;;

public class ProdutoDAO extends AbstractDAO<Produto> {

	public List<Produto> buscarProdutoPorTipoProdutoId(int id) {

		Query query = getSession().createQuery("from Produto where cod_tipo_produto = :idTipoProduto");
		query.setParameter("idTipoProduto", id);
		List<Produto> lista = query.list();
		getSession().close();

		return lista;

	}


}