package br.usjt.desenvolvimentoweb.model.service;



import br.usjt.desenvolvimentoweb.model.dao.AnoDAO;
import br.usjt.desenvolvimentoweb.model.entity.Ano;

public class AnoService {
	AnoDAO dao = new AnoDAO();
	
	public int criar(Ano ano) {
		return dao.criar(ano);
	}
	
	public void atualizar(Ano ano){
		dao.atualizar(ano);
	}
	
	public void excluir(Ano ano){
		dao.excluir(ano);
	}
	
	public Ano carregar(int id){
		return dao.carregar(id);
	}

}
