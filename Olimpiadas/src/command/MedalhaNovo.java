package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.service.AnoService;
import usjt.olimpiada.service.ModalidadeService;
import usjt.olimpiada.service.PaisService;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de cria��o: 11/05/2018
 * 
 */
public class MedalhaNovo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PaisService ps = new PaisService();
		AnoService as = new AnoService();
		ModalidadeService ms = new ModalidadeService();
		
		request.setAttribute("paises", ps.buscaPaises());
		request.setAttribute("anos", as.buscaAnos());
		request.setAttribute("modalidades", ms.buscaModalidades());
		
		request.setAttribute("menu", "medalha");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/FormularioQuadro.jsp");
		view.forward(request, response);
	}

}
