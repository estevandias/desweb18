package usjt.olimpiada.model;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de Criação: 17/05/2018
 * 
 */
public class Usuario {

	private String usuario;
	private String senha;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", senha=" + senha + "]";
	}
	
}
