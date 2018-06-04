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
 * Data de criação: 11/05/2018
 * 
 */
public class Pais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PaisService ps = new PaisService();
		
		request.setAttribute("paises", ps.buscaPaises());
		
		request.setAttribute("menu", "pais");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Paises.jsp");
		view.forward(request, response);
	}

}
