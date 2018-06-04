package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de cria��o: 11/05/2018
 * 
 */
public class ModalidadeNovo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("menu", "modalidade");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/FormularioModalidade.jsp");
		view.forward(request, response);

	}

}
