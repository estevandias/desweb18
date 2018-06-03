package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Modalidade;
import model.Olimpiada;
import model.Pais;
import service.ModalidadeService;
import service.OlimpiadaService;
import service.PaisService;

public class PaginaPesquisarOlimpiada implements Command {
	
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PaisService ps = new PaisService();
		ModalidadeService ms = new ModalidadeService();
		OlimpiadaService os = new OlimpiadaService();
		
		List<Pais> pais = ps.listar();
		List<Modalidade> modalidade = ms.listar();
		List<Olimpiada> olimpiada = os.listar();
		
		HttpSession session = request.getSession();
		RequestDispatcher view = null;
		
		session.setAttribute("pais", pais);
		session.setAttribute("modalidade", modalidade);
		session.setAttribute("olimpiada", olimpiada);
		
		view = request.getRequestDispatcher("OlimpiadasPesquisar.jsp");
		
		view.forward(request, response);
	}
}
