package perm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;

@WebFilter(urlPatterns = "/faces/restrito/*")
public class RestritoFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		Pessoa u = null;

		HttpSession sesison = ((HttpServletRequest) req).getSession(false);
		

		if (sesison != null) {
			u = (Pessoa) sesison.getAttribute("usuario-logado");
		}
		
		System.out.println("NOME--- " + u.getNome());

		if (u == null) {
			String contextPath = ((HttpServletRequest) req).getContextPath();
			((HttpServletResponse) res).sendRedirect(contextPath + "/faces/index.xhtml#conta");
		} else {

			chain.doFilter(req, res);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}