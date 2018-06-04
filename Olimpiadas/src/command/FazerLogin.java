package usjt.olimpiada.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usjt.olimpiada.model.Usuario;
import usjt.olimpiada.service.UsuarioService;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de Criação: 17/05/2018
 */
public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		UsuarioService us = new UsuarioService();
		
		String user = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		usuario.setUsuario(user);
		usuario.setSenha(senha);
		
		if(us.validaUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Sucesso no login: " + usuario);
		}else {
			System.out.println("Sem sucesso no login: " + usuario);
			throw new ServletException("Usuario ou senha invalidos");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Home.jsp");
		view.forward(request, response);
		
	}

}
