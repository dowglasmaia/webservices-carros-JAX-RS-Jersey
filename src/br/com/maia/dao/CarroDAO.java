package br.com.maia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	// find ByName
	public List<Carro> findByName(String nome) throws SQLException {
		List<Carro> carros = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = connection();
			stmt = conn.prepareStatement("select * from carro where lower(nome) like ?");
			stmt.setString(1, "%" + nome.toLowerCase() + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Carro c = createCarro(rs);
				carros.add(c);
			}
			rs.close();

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
