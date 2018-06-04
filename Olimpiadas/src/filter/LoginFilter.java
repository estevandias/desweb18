package usjt.olimpiada.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import usjt.olimpiada.model.Usuario;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de Criação: 17/05/2018
 * 
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario UsuarioLogado = (Usuario) session.getAttribute("logado");
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String comando = req.getParameter("command");
		
		if(comando == null) {
			comando = "";
		}
		
		if(UsuarioLogado == null && !uri.equals(path + "/LoginOlimpiada.jsp")
				&& !comando.equals("FazerLogin")) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/LoginOlimpiada.jsp");
			view.forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
