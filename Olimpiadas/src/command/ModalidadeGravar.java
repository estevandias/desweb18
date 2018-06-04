package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.model.Modalidade;
import usjt.olimpiada.service.ModalidadeService;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de criação: 11/05/2018
 * 
 */
public class ModalidadeGravar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModalidadeService ms = new ModalidadeService();
		
		//Monta objeto com parametros recebidos da request.
		int idModalidade = 0;
		
		if((request.getParameter("id") != null) && !(request.getParameter("id").isEmpty())) {	
			idModalidade = Integer.parseInt(request.getParameter("id"));
		}
		String nomeModalidade = request.getParameter("nome");
		char tipo = request.getParameter("tipo").charAt(0);
		
		//Variavel auxiliar para verificar a gravacao
		boolean gravado = false;
		
		Modalidade modalidade = new Modalidade();
		modalidade.setNome(nomeModalidade);
		modalidade.setTipo(tipo);
		
		if (idModalidade > 0) {
			modalidade.setId(idModalidade);
			gravado = ms.atualizar(modalidade);
		}else {
			gravado = ms.criar(modalidade);
		}
		
		if(gravado) {
			request.setAttribute("menu", "modalidade");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/SucessoGravacao.jsp");
			view.forward(request, response);;
		}
	}

}
