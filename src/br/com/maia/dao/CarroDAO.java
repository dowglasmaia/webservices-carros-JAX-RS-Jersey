package br.com.maia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.maia.domain.Carro;

public class CarroDAO extends BaseDAO {
	private static final long serialVersionUID = 1L;

	// Buscar por ID
	public Carro findById(Long id) throws SQLException {
		Connection conn = null;

		PreparedStatement stmt = null;

		try {
			// recebe conexão da class BaseDAO
			conn = connection();

			stmt = conn.prepareStatement("select * from carro where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Carro c = createCarro(rs);
				rs.close();
				return c;
			}

		} finally {

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

	// create
	private Carro createCarro(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
