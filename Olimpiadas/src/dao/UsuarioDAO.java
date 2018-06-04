package usjt.olimpiada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import usjt.olimpiada.model.Usuario;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de Criação: 17/05/2018
 */
public class UsuarioDAO {

	public boolean validaUsuario(Usuario usuario) {
		boolean validador = false;;
		String sqlSelect = "SELECT usuario FROM usuario WHERE usuario = ? AND senha = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, usuario.getUsuario());
			stm.setString(2, usuario.getSenha());
			
			try (ResultSet rs = stm.executeQuery();) {
				
				if (rs.next()) validador = true;
				else validador = false;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return validador;
	}

}
