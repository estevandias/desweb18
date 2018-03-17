package br.usjt.desenvolvimentoweb.model.service;



import br.usjt.desenvolvimentoweb.model.dao.ModalidadeDAO;
import br.usjt.desenvolvimentoweb.model.entity.Modalidade;


public class ModalidadeService {
	ModalidadeDAO dao = new ModalidadeDAO();
	
	public int criar(Modalidade modalidade) {
		return dao.criar(modalidade);
	}
	
	public void atualizar(Modalidade modalidade){
		dao.atualizar(modalidade);
	}
	
	public void excluir(Modalidade modalidade){
		dao.excluir(modalidade);
	}
	
	public Modalidade carregar(int id){
		return dao.carregar(id);
	}

}