package br.com.maia.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.maia.dao.CarroDAO;
import br.com.maia.domain.Carro;

public class CarroService {

	private CarroDAO dao;

	public CarroService() {
		this.dao = new CarroDAO();
	}

	// listar todos os carros
	public List<Carro> getAll() {
		try {
			List<Carro> result = dao.getAll();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>(); // retorna uma lista Vazia
		}
	}

	// buscar pelo Id
	public Carro getById(Long id) {
		try {
			return dao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// delete
	public boolean delete(Long id) {
		try {
			return dao.delete(id);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// save ou update
	public boolean saveOuUpdate(Carro carro) {
		try {
			dao.save(carro);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// buscar pelo nome
	public List<Carro> getByName(String nome) {
		try {
			return dao.findByName(nome);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>(); // retorna uma lista Vazia
		}
	}

	// buscar por tipo
	public List<Carro> getByTipo(String tipo) {
		try {
			return dao.findByTipo(tipo);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>(); // retorna uma lista Vazia
		}
	}

}
