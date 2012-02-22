package net.spirion.nomadrail.example.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Random;

import net.spirion.nomadrail.example.model.CCURecord;
import net.spirion.nomadrail.example.model.GPSRecord;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Test class for the CCUCoordinateRepository.
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
public class CCUCoordinateRepositoryTest {

	@Autowired private CCUCoordinateRepository repository;
	
	@Before
	public void befortTest() {
		// clear the repository down before we begin
		repository.deleteAll();
	}
	
	@Test
	public void testRepository() {
		// insert a number of new records
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
		
		// there should be 100 CCU records
		assertEquals(this.repository.count(), 100);
		
		// the ccu-0 and ccu-99 designations should be present
		Collection<CCURecord> ccu = this.repository.findByDesignation("ccu-0");
		assertEquals(ccu.size(), 1);
		ccu = this.repository.findByDesignation("ccu-99");
		assertEquals(ccu.size(), 1);
		
	}
	
}