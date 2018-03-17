package br.usjt.desenvolvimentoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.desenvolvimentoweb.model.entity.Pais;

public class PaisDAO {
	
	ConnectionFactory connn = new ConnectionFactory();

			public int criar(Pais pais) {
				String sqlInsert = "INSERT INTO pais(id, nome, populacao, area) VALUES (?, ?, ?)";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
					stm.setString(1, pais.getNome());
					stm.setLong(2, pais.getPopulacao());
					stm.setDouble(3, pais.getArea());
					stm.execute();
					String sqlQuery  = "SELECT LAST_INSERT_ID()";
					try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
						if(rs.next()){
							pais.setId(rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return pais.getId();
				}

			public void atualizar(Pais pais) {
				String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setString(1, pais.getNome());
					stm.setLong(2, pais.getPopulacao());
					stm.setDouble(3, pais.getArea());
					stm.setInt(4, pais.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void excluir(Pais pais) {
				String sqlDelete = "DELETE FROM pais WHERE id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, pais.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
			public Pais carregar(int id) {
				Pais pais = new Pais();
				pais.setId(id);
				String sqlSelect = "SELECT nome, populacao, area, id FROM pais WHERE pais.id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection connn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = connn.prepareStatement(sqlSelect);) {
					stm.setInt(1, pais.getId());
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							pais.setNome(rs.getString("nome"));
							pais.setPopulacao(rs.getLong("populacao"));
							pais.setArea(rs.getDouble("area"));
						} else {
							pais.setId(-1);
							pais.setNome(null);
							pais.setPopulacao(0);
							pais.setArea(0);
												
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return pais;
			}
			
			
			
		

}

