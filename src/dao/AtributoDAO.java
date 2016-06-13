package dao;

import java.util.List;

import org.hibernate.Query;

import model.Atributo;

public class AtributoDAO extends AbstractDAO<Atributo> {

	public List<Atributo> buscarAtributoPorTipoProduto(int id) {

		Query query = getSession().createQuery("from Atributo where cod_tipo_produto = :idTipoProduto");
		query.setParameter("idTipoProduto", id);
		List<Atributo> lista = query.list();
		getSession().close();

		return lista;

	}

}
