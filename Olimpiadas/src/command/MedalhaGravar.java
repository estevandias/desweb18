package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.model.Ano;
import usjt.olimpiada.model.Modalidade;
import usjt.olimpiada.model.Olimpiada;
import usjt.olimpiada.model.Pais;
import usjt.olimpiada.service.AnoService;
import usjt.olimpiada.service.ModalidadeService;
import usjt.olimpiada.service.OlimpiadaService;
import usjt.olimpiada.service.PaisService;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de criação: 11/05/2018
 * 
 */
public class MedalhaGravar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnoService as = new AnoService();
		ModalidadeService ms = new ModalidadeService();
		PaisService ps = new PaisService();
		OlimpiadaService os = new OlimpiadaService();
		
		//Monta objeto com parametros recebidos da request.
		int idQuadro = 0;
		
		if((request.getParameter("id") != null) && !(request.getParameter("id").isEmpty())) {	
			idQuadro = Integer.parseInt(request.getParameter("id"));
		}
		
		int ouro = Integer.parseInt(request.getParameter("ouro"));
		int prata = Integer.parseInt(request.getParameter("prata"));
		int bronze = Integer.parseInt(request.getParameter("bronze"));;
		
		int idPais = Integer.parseInt(request.getParameter("pais"));
		int idModalidade = Integer.parseInt(request.getParameter("modalidade"));
		int idAno = Integer.parseInt(request.getParameter("ano"));
		
		Ano ano = as.carregar(idAno);
		Modalidade modalidade = ms.carregar(idModalidade);
		Pais pais = ps.carregar(idPais);
		
		//Variavel auxiliar para verificar a gravacao
		boolean gravado = false;
		
		Olimpiada olimpiada = new Olimpiada();
		olimpiada.setOuro(ouro);
		olimpiada.setPrata(prata);
		olimpiada.setBronze(bronze);
		olimpiada.setAno(ano);
		olimpiada.setModalidade(modalidade);
		olimpiada.setPais(pais);
		
		if (idQuadro > 0) {
			olimpiada.setId(idQuadro);
			gravado = os.atualizar(olimpiada);
		}else {
			gravado = os.criar(olimpiada);
		}
		
		if(gravado) {
			request.setAttribute("menu", "medalha");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/SucessoGravacao.jsp");
			view.forward(request, response); 
		}
	}

}
