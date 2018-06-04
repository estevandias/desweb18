package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.service.OlimpiadaService;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de cria��o: 11/05/2018
 * 
 */
public class Medalha implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OlimpiadaService os = new OlimpiadaService();
		
		request.setAttribute("menu", "medalha");
		request.setAttribute("quadros", os.listaQuadro());
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/ListagemQuadroMedalhas.jsp");
		view.forward(request, response);
	}

}
