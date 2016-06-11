package dao;

import model.TipoProduto;

public class TipoProdutoDAO extends AbstractDAO<TipoProduto> {

	public static TipoProduto buscarPorId(int id) {
		TipoProduto tp = new TipoProdutoDAO().findById(id);

		return tp;
	}

}
