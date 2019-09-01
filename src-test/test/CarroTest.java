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

	}

	public void testSalvarDelete() {
		Carro cr = new Carro();
		cr.setNome("Test 2019");
		cr.setDesc("Desc Test");
		cr.setLatitude("Latit test");
		cr.setLongitude("01231 test");
		cr.setTipo("Test Tipo");
		cr.setUrlFoto("url test");
		cr.setUrlVideo("Test video");
		cservice.saveOuUpdate(cr);

		// id do carro salvo
		Long id = cr.getId();
		assertNotNull(id);

		// Buscar por id
		cr = cservice.getById(id);

		assertEquals("Test 2019", cr.getNome());
		assertEquals("Desc Test", cr.getDesc());
		assertEquals("Latit test", cr.getLatitude());
		assertEquals("01231 test", cr.getLongitude());
		assertEquals("Test Tipo", cr.getTipo());
		assertEquals("url test", cr.getUrlFoto());
		assertEquals("Test video", cr.getUrlVideo());

		// update
		cr.setNome("Test Update");
		cservice.saveOuUpdate(cr);

		// buscar Test atualizado
		cr = cservice.getById(id);
		assertEquals("Test Update", cr.getNome());

		// delete
		cservice.delete(id);
		assertNotNull(cr);

	}

}
