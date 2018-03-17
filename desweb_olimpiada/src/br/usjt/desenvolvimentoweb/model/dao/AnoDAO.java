package br.usjt.desenvolvimentoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.desenvolvimentoweb.model.entity.Ano;

public class AnoDAO {
	
	ConnectionFactory connn = new ConnectionFactory();
	
			

			public int criar(Ano ano) {
				String sqlInsert = "INSERT INTO ano(id, tipo) VALUES (?)";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
					stm.setString(1, ano.getTipo());
					stm.execute();
					String sqlQuery  = "SELECT LAST_INSERT_ID()";
					try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
						if(rs.next()){
							ano.setId(rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return ano.getId();
			}

			public void atualizar(Ano ano) {
				String sqlUpdate = "UPDATE ano SET tipo=? WHERE id=?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setString(1, ano.getTipo());
					stm.setInt(2, ano.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void excluir(Ano ano) {
				String sqlDelete = "DELETE FROM ano WHERE id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, ano.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public Ano carregar(int id) {
				Ano ano = new Ano();
				ano.setId(id);
				String sqlSelect = "SELECT tipo FROM ano WHERE ano.id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setInt(1, ano.getId());
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							ano.setTipo(rs.getString("tipo"));
							
						} else {
							ano.setId(-1);
							ano.setTipo(null);
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return ano;
			}

			
			
			
			
			
		

}
