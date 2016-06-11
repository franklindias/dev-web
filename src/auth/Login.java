package auth;

import dao.PessoaDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Pessoa;
import util.ErroUtil;
import util.MessageUtil;
import util.SessionUtil;

@RequestScoped
@ManagedBean(name = "validador")
public class Login implements Serializable {

	PessoaDAO pessoaDAO;
	private String username;
	private String password;

	public String autenticar() throws ErroUtil {

		pessoaDAO = new PessoaDAO();
		List<Pessoa> usuarios = pessoaDAO.findAll();

		for (Pessoa p : usuarios) {
			if (password.equals(p.getPassword()) && username.equals(p.getUsername())) {
				System.out.println(p.getNome());
				SessionUtil.setParamSession("usuario-logado", p);
				
				if (p.geteAdmin()) {

					return "/faces/restrito/admin/dash.xhtml";

				} else {
					return "/faces/restrito/user/dash.xhtml";
				}

			}
		}

		MessageUtil.MensagemErro("Usuário ou senha inválidos!");
		return null;
	}

	public String logout() {
		SessionUtil.invalidateSession();
		return "/faces/index.xhtml";
	}

	public void sair() {
		SessionUtil.invalidateSession();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
