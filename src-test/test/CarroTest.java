package test;

import java.util.List;

import br.com.maia.domain.Carro;
import br.com.maia.services.CarroService;
import junit.framework.TestCase;

public class CarroTest extends TestCase {

	private CarroService cservice = new CarroService();

	
	public void testListacarro() {
		List<Carro> carros = cservice.getAll();

		assertNotNull(carros);
		// valida se encontrou algo
		assertTrue(carros.size() > 0);

		// valida de encontrou o Tucker
		Carro tucker = cservice.getByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", tucker.getNome());
		
		//valida se encontrou a ferrare

	}

}
