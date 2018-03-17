package br.usjt.desenvolvimentoweb.model.service;



import br.usjt.desenvolvimentoweb.model.dao.PaisDAO;
import br.usjt.desenvolvimentoweb.model.entity.Pais;



public class PaisService {
	PaisDAO dao = new PaisDAO();
	
	public int criar(Pais pais) {
		return dao.criar(pais);
	}
	
	public void atualizar(Pais pais){
		dao.atualizar(pais);
	}
	
	public void excluir(Pais pais){
		dao.excluir(pais);
	}
	
	public Pais carregar(int id){
		return dao.carregar(id);
	}

}