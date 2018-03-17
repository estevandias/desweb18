package br.usjt.desenvolvimentoweb.model.entity;

public class Olimpiada {
	
	private int ouro;
	private int prata;
	private int bronze;
	
	
	public Olimpiada(int ouro, int prata, int bronze) {
		super();
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;
	}


	public int getOuro() {
		return ouro;
	}


	public void setOuro(int ouro) {
		this.ouro = ouro;
	}


	public int getPrata() {
		return prata;
	}


	public void setPrata(int prata) {
		this.prata = prata;
	}


	public int getBronze() {
		return bronze;
	}


	public void setBronze(int bronze) {
		this.bronze = bronze;
	}


	@Override
	public String toString() {
		return "Olimpiada [ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze + "]";
	}
	
	
	
	
	
	

}
