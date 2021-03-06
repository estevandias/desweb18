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
 * Data de cria��o: 11/05/2018
 * 
 */
public class MedalhaEditar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PaisService ps = new PaisService();
		AnoService as = new AnoService();
		ModalidadeService ms = new ModalidadeService();
		OlimpiadaService os = new OlimpiadaService();
		
		int idPais = Integer.parseInt(request.getParameter("pais"));
		int idModalidade = Integer.parseInt(request.getParameter("modalidade"));
		int idAno = Integer.parseInt(request.getParameter("ano"));
		
		//Cria instancias com ID para fazer a exclus�o;
		Pais pais = new Pais();
		pais.setId(idPais);
		
		Modalidade modalidade = new Modalidade();
		modalidade.setId(idModalidade);
		
		Ano ano = new Ano();
		ano.setAno(idAno);
		
		Olimpiada olimpiada = new Olimpiada();
		olimpiada.setPais(pais);
		olimpiada.setModalidade(modalidade);
		olimpiada.setAno(ano);
		
		request.setAttribute("paises", ps.buscaPaises());
		request.setAttribute("anos", as.buscaAnos());
		request.setAttribute("modalidades", ms.buscaModalidades());
		request.setAttribute("quadro", os.carregar(olimpiada));
		
		request.setAttribute("menu", "medalha");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/FormularioQuadro.jsp");
		view.forward(request, response);
	}

}
