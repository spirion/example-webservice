package net.spirion.nomadrail.example.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import net.spirion.nomadrail.example.model.CCURecord;
import net.spirion.nomadrail.example.model.GPSRecord;
import net.spirion.nomadrail.example.repositories.CCUCoordinateRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test class for the CCUCoordinateService.
 * </p>
 * <p>
 * IMPORTANT: Ensure when running this test that the system property named "spring.profiles.active" is set to "test"
 * otherwise the Spring Application Context will not load.
 * </p>
 * 
 * @author Michael
 * @version 1.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/net/spirion/nomadrail/example/context/application-context.xml"})
public class CCUCoordinateServiceTest {

	@Autowired private CCUCoordinateRepository repository;
	@Autowired private CCUCoordinateService service;
	
	@Before
	public void beforeTest() {
		// reset the repository and fill it with records
		this.repository.deleteAll();
		Random gen = new Random(System.currentTimeMillis());
		for (int i = 0; i < 100 ; i++) {
			GPSRecord gps = new GPSRecord
				((int)(gen.nextDouble() * 360) - 180,
				 (gen.nextDouble() * 360) - 180,
				 (gen.nextDouble() * 360) - 180,
				 1,
				 (int)(gen.nextDouble() * 200));
			CCURecord ccu = new CCURecord("ccu-" + i, gps);
			this.repository.save(ccu);
		}
	}
	
	@Test
	public void testListCoordinates() {
		List<CCURecord> l = null;
		try {
			l = this.service.listCoordinates();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(l);
	}
	
}
