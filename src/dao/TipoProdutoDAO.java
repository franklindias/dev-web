package dao;

import java.util.List;

import org.hibernate.Query;

import model.TipoProduto;
import util.HibernateUtil;

public class TipoProdutoDAO extends AbstractDAO<TipoProduto> {

	public static TipoProduto buscarPorId(int id) {
		TipoProduto tp = new TipoProdutoDAO().findById(id);

		return tp;
	}

	public List<TipoProduto> buscarAtivos() {
		
		Query query = getSession().createQuery("from TipoProduto where status = True");
		List<TipoProduto> lista = query.list();
		getSession().close();
		
		return lista;

	}

}
