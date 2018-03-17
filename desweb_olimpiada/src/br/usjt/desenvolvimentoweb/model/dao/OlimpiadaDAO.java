package br.usjt.desenvolvimentoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.desenvolvimentoweb.model.entity.Ano;
import br.usjt.desenvolvimentoweb.model.entity.Modalidade;
import br.usjt.desenvolvimentoweb.model.entity.Olimpiada;
import br.usjt.desenvolvimentoweb.model.entity.Pais;

public class OlimpiadaDAO {
	
	
	Pais pais = new Pais();
	Ano ano = new Ano();
	Modalidade modalidade = new Modalidade();
	ConnectionFactory connn = new ConnectionFactory();
	
			public void criar(Olimpiada olimpiada) {
				
				String sqlInsert = "INSERT INTO pais(ouro, prata, bronze) VALUES (?, ?, ?)";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = connn.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
					stm.setInt(1, olimpiada.getOuro());
					stm.setInt(2, olimpiada.getPrata());
					stm.setInt(3, olimpiada.getBronze());
					stm.execute();
					String sqlQuery  = "SELECT LAST_INSERT_ID()";
					try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
						if(rs.next()){
							olimpiada.setId(rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			public void atualizar(Olimpiada olimpiada) {
				String sqlUpdate = "UPDATE pais SET ouro=?, prata=?, bronze=? WHERE id=?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = connn.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setInt(1, olimpiada.getOuro());
					stm.setInt(2, olimpiada.getPrata());
					stm.setInt(3, olimpiada.getBronze());
					
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void excluir(Olimpiada olimpiada) {
				String sqlDelete = "DELETE FROM pais WHERE id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = connn.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, olimpiada.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void carregar(Olimpiada olimpiada) {
				
				
				
				String sqlSelect = "SELECT ouro, prata, bronze, id FROM pais WHERE pais.id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = connn.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setInt(1, olimpiada.getId());
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							olimpiada.setOuro(rs.getInt("ouro"));
							olimpiada.setPrata(rs.getInt("prata"));
							olimpiada.setBronze(rs.getInt("bronze"));
						} else {
							
							olimpiada.setOuro(0);
							olimpiada.setPrata(0);
							olimpiada.setBronze(0);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
			
			
			
			
		

}
