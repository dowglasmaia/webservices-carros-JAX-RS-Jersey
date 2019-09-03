package br.com.maia.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.maia.domain.Carro;
import br.com.maia.domain.ListaCarros;
import br.com.maia.services.CarroService;
import br.com.maia.util.JAXBUtil;
import br.com.maia.util.ServletUtil;

@WebServlet("/carros/*")
public class CarroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CarroService carroService = new CarroService();

	/* 
	 */// ======XML==========*/
	/*
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * List<Carro> carros = carroService.getAll();
	 * 
	 * // class ListaCarros ListaCarros list = new ListaCarros();
	 * list.setCarros(carros);
	 * 
	 * // gera XML String xml = JAXBUtil.toXML(list);
	 * 
	 * // escreve o XML na Resposta ServletUtil.writeXML(resp, xml);
	 * 
	 * }
	 * 
	 */
	/* ======JSON===== */
	/*
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * List<Carro> carros = carroService.getAll();
	 * 
	 * // class ListaCarros ListaCarros list = new ListaCarros();
	 * list.setCarros(carros);
	 * 
	 * // gera JSON String json = JAXBUtil.toJSON(list);
	 * 
	 * // escreve o JSON na Resposta do servlet com application/json
	 * ServletUtil.writeJSON(resp, json); }
	 */

	/* ======JSON====com==== GSON === */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Carro> carros = carroService.getAll();

		// class ListaCarros
		ListaCarros list = new ListaCarros();
		list.setCarros(carros);

		// gera JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);

		// escreve o JSON na Resposta do servlet com application/json
		ServletUtil.writeJSON(resp, json);
	}

}
