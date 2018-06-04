package usjt.olimpiada.service;

import usjt.olimpiada.dao.UsuarioDAO;
import usjt.olimpiada.model.Usuario;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de Criação: 17/05/2018
 */
public class UsuarioService {

	UsuarioDAO uDAO = new UsuarioDAO();
	
	public boolean validaUsuario(Usuario usuario) {
		return uDAO.validaUsuario(usuario);
	}
}
