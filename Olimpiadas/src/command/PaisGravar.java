package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.model.Pais;
import usjt.olimpiada.service.PaisService;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de criação: 11/05/2018
 * 
 */
public class PaisGravar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PaisService ps = new PaisService();
		
		//Monta objeto com parametros recebidos da request.
		int idPais = 0;

		if((request.getParameter("id") != null) && !(request.getParameter("id").isEmpty())) {	
			idPais = Integer.parseInt(request.getParameter("id"));
		}
		String nomePais = request.getParameter("nome");
		long populacaoPais = Long.parseLong(request.getParameter("populacao"));
		double areaPais = Double.parseDouble(request.getParameter("area"));
		
		//Variavel auxiliar para verificar a gravacao
		boolean gravado = false;
		
		Pais pais = new Pais();
		pais.setNome(nomePais);
		pais.setPopulacao(populacaoPais);
		pais.setArea(areaPais);
		
		if (idPais > 0) {
			pais.setId(idPais);
			gravado = ps.atualizar(pais);
		}else {
			gravado = ps.criar(pais);
		}
		
		if(gravado) {
			request.setAttribute("menu", "pais");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/SucessoGravacao.jsp");
			view.forward(request, response);
		}

	}

}
