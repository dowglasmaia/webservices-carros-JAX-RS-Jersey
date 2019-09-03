package br.com.maia.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

import br.com.maia.domain.Carro;
import br.com.maia.domain.ListaCarros;

public class JAXBUtil {

	private static JAXBUtil instance;

	private static JAXBContext context;

	public static JAXBUtil getInstance() {
		return instance;
	}

	// informa ao JAXB que é para gerar o XML destas classes
	static {
		try {
			context = JAXBContext.newInstance(ListaCarros.class, Carro.class);
		} catch (JAXBException ex) {
			throw new RuntimeException(ex);
		}
	}

	// XML
	public static String toXML(Object object) throws IOException {
		try {
			StringWriter writer = new StringWriter();
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(object, writer);
			String xml = writer.toString();
			return xml;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	// JSON
	public static String toJSON(Object object) throws IOException {
		try {
			StringWriter writer = new StringWriter();
			Marshaller m = context.createMarshaller();

			MappedNamespaceConvention conn = new MappedNamespaceConvention();
			XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(conn, writer);
			m.marshal(object, xmlStreamWriter);
			String json = writer.toString();

			return json;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

}
