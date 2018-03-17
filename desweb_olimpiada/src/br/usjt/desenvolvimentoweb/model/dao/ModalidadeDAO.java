package br.usjt.desenvolvimentoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.desenvolvimentoweb.model.entity.Modalidade;

public class ModalidadeDAO {
	
	ConnectionFactory connn = new ConnectionFactory();

			public int criar(Modalidade modalidade) {
				String sqlInsert = "INSERT INTO modalidade(id, nome, tipo) VALUES (?, ?)";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
					stm.setString(1, modalidade.getNome());
					stm.setString(2, modalidade.getTipo());
					
					stm.execute();
					String sqlQuery  = "SELECT LAST_INSERT_ID()";
					try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
						if(rs.next()){
							modalidade.setId(rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return modalidade.getId();
			}

			public void atualizar(Modalidade modalidade) {
				String sqlUpdate = "UPDATE modalidade SET nome=?, tipo=?,  WHERE id=?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setString(1, modalidade.getNome());
					stm.setString(2, modalidade.getTipo());
					stm.setInt(3, modalidade.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void excluir(Modalidade modalidade) {
				String sqlDelete = "DELETE FROM modalidade WHERE id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, modalidade.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public Modalidade carregar(int id) {
				Modalidade modalidade = new Modalidade();
				String sqlSelect = "SELECT nome, tipo, id FROM modalidade WHERE modalidade.id = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setInt(1, modalidade.getId());
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							modalidade.setNome(rs.getString("nome"));
							modalidade.setTipo(rs.getString("tipo"));
							
						} else {
							modalidade.setId(-1);
							modalidade.setNome(null);
							modalidade.setTipo(null);
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return modalidade;
			}
			
			
			
			
		

}

