package usjt.olimpiada.filter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import usjt.olimpiada.model.Usuario;
import usjt.olimpiada.util.Log;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de Criaï¿½ï¿½o: 17/05/2018
 * Data de Modificação 25/05/2018
 */
@WebFilter("/*")
public class LogFilter implements Filter {
 
	FilterConfig filterConfig = null;
	/**
	 * Default constructor.
	 */
	public LogFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String comandoReq = req.getParameter("command");
		Usuario usuario = (Usuario)session.getAttribute("logado");
		
		//Caso seja somente a raiz e nÃ£o possua comando requisitado pelo usuÃ¡rio
		if (comandoReq == null) {
			comandoReq = req.getRequestURI();
		}
		
		//Busca os valores para identificar o LOG
		Calendar dataTempo = Calendar.getInstance();
		String txtLog = "";
		ServletContext servletContext = filterConfig.getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		//System.out.println(usuario.getUsuario() + "->" + req.getParameter("command"));
		
		if(usuario == null) {
			txtLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL%tp] %s\n", 
					dataTempo, comandoReq);
		}
		else {
			txtLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL%tp] %s -> %s\n", 
					dataTempo, usuario.getUsuario(), comandoReq);
		}

		synchronized (txtLog) {
			Log arquivoLog = new Log();
			arquivoLog.abrir(contextPath + File.separator + "log" + File.separator + Log.NOME);
			arquivoLog.escrever(txtLog);
			arquivoLog.fechar();
		}
		
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		filterConfig = fConfig;
	}

}
