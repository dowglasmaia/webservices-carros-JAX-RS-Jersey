package br.com.maia.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Dowglas Maia
 * @since Class aux para escrever um XML ou JSON
 */

public class ServletUtil {

	// Formato XML na resposta
	public static void writeXML(HttpServletResponse response, String xml) throws IOException {
		if (xml != null) {
			PrintWriter writer = response.getWriter();
			response.setContentType("application/xml; charset=UTF-8");
			writer.write(xml);
			writer.close();
		}
	}

	// Formato JSON na resposta
	public static void writeJSON(HttpServletResponse response, String json) throws IOException {
		if (json != null) {
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json; charset=UTF-8");
			writer.write(json);
			writer.close();
		}
	}

}
