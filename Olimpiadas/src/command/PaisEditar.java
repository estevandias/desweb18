package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.service.PaisService;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de cria��o: 11/05/2018
 * 
 */
public class PaisEditar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PaisService ps = new PaisService();
		
		int idPais = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("pais", ps.carregar(idPais));
		
		request.setAttribute("menu", "pais");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/FormularioPais.jsp");
		view.forward(request, response);

	}

}
