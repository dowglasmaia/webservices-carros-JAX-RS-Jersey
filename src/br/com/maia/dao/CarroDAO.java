package br.com.maia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.maia.domain.Carro;

public class CarroDAO extends BaseDAO {
	private static final long serialVersionUID = 1L;

	// create - util
	private Carro createCarro(ResultSet rs) throws SQLException {
		Carro cr = new Carro();
		cr.setId(rs.getLong("id"));
		cr.setTipo(rs.getString("tipo"));
		cr.setNome(rs.getString("nome"));
		cr.setDesc(rs.getString("descricao"));
		cr.setUrlFoto(rs.getString("url_foto"));
		cr.setUrlVideo(rs.getString("url_video"));
		cr.setLatitude(rs.getString("latitude"));
		cr.setLongitude(rs.getString("longitude"));

		return cr;
	}

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
		return carros;

	}

	// Find By Tipo
	public List<Carro> findByTipo(String tipo) throws SQLException {
		List<Carro> carros = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = connection();
			stmt = conn.prepareStatement("select * form carro where tipo =?");
			stmt.setString(1, tipo);
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
		return carros;
	}

	// getAll
	public List<Carro> getAll() throws SQLException {
		List<Carro> carros = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = connection();
			stmt = conn.prepareStatement("select * from carro");
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
		return carros;
	}

	// save
	public void save(Carro c) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = connection();
			// insert via JDBC
			if (c.getId() == null) {
				stmt = conn.prepareStatement(
						"insert into carro (tipo,nome,descricao,url_foto,url_video,latitude,longitude) VALUES(?,?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
			} else {
				// update
				stmt = conn.prepareStatement(
						"update carro set tipo=?,nome=?,descricao=?,url_foto=?,url_video=?,latitude=?,longitude=? where id=?");

			}
			// save
			stmt.setString(1, c.getTipo());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getDesc());
			stmt.setString(4, c.getUrlFoto());
			stmt.setString(5, c.getUrlVideo());
			stmt.setString(6, c.getLatitude());
			stmt.setString(7, c.getLongitude());
			// update
			if (c.getId() != null) {
				stmt.setLong(8, c.getId());
			}
			int count = stmt.executeUpdate();
			if (count == 0) {
				throw new SQLException("Error ao Inserir Dados!");
			}
			// se inseriu, ler o id auto incremento
			if (c.getId() == null) {
				Long id = getGeneratedId(stmt);
				c.setId(id);
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

	// gerando o id auto incremented
	private Long getGeneratedId(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			Long id = rs.getLong(1);
			return id;
		}
		return 0L;
	}

	// delete
	public boolean delete(Long id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = connection();
			stmt = conn.prepareStatement("delete from carro where id=?");
			stmt.setLong(1, id);
			int count = stmt.executeUpdate();
			boolean ok = count > 0;
			return ok;

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
