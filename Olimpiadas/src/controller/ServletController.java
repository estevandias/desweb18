package usjt.olimpiada.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.command.Command;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de criação: 11/05/2018
 * 
 */
@WebServlet("/olimpiadaController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			request.setCharacterEncoding("UTF-8");
			Command comando = (Command)Class.forName("usjt.olimpiada.command."+request.getParameter("command")).newInstance();
			request.setAttribute("menu", request.getServletPath());
			comando.executar(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doExecute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doExecute(request, response);
	}

}
