package controller;

import dao.ValorAtributoDAO;
import model.ValorAtributo;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ValorAtributoBean {

	private ValorAtributo valorAtributo;
	private DataModel<ValorAtributo> listaValorAtributos;

	public ValorAtributoBean() {
		List<ValorAtributo> lista = new ValorAtributoDAO().findAll();
		listaValorAtributos = new ListDataModel<ValorAtributo>(lista);
		valorAtributo = new ValorAtributo();
	}

	public void cadastrar() {
		new ValorAtributoDAO().save(valorAtributo);
		List<ValorAtributo> lista = new ValorAtributoDAO().findAll();
		listaValorAtributos = new ListDataModel<ValorAtributo>(lista);
		valorAtributo = new ValorAtributo();
	}

	public void alterar() {
		new ValorAtributoDAO().alter(valorAtributo);
		List<ValorAtributo> lista = new ValorAtributoDAO().findAll();
		listaValorAtributos = new ListDataModel<ValorAtributo>(lista);
		valorAtributo = new ValorAtributo();
	}

	public void excluir() {
		new ValorAtributoDAO().delete(valorAtributo);
		List<ValorAtributo> lista = new ValorAtributoDAO().findAll();
		listaValorAtributos = new ListDataModel<ValorAtributo>(lista);
		valorAtributo = new ValorAtributo();
	}

	public ValorAtributo getValorAtributo() {
		return valorAtributo;
	}

	public void setValorAtributo(ValorAtributo valorAtributo) {
		this.valorAtributo = valorAtributo;
	}

	public DataModel<ValorAtributo> getListaValorAtributos() {
		List<ValorAtributo> lista = new ValorAtributoDAO().findAll();
		listaValorAtributos = new ListDataModel<ValorAtributo>(lista);
		return listaValorAtributos;
	}

	public void setListaValorAtributos(DataModel<ValorAtributo> listaValorAtributos) {
		this.listaValorAtributos = listaValorAtributos;
	}

	public void logar() {

	}

}