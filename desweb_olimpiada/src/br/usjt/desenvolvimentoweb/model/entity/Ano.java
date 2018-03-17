package br.usjt.desenvolvimentoweb.model.entity;

public class Ano {

	private int id;
	private String tipo;
	
	
	public Ano() {
		
	
	}
	
	public Ano(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Ano [id=" + id + ", tipo=" + tipo + "]";
	}
	

	
	
	
}
