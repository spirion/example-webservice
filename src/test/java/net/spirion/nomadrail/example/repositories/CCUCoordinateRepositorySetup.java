package net.spirion.nomadrail.example.repositories;

import java.util.Random;

import net.spirion.nomadrail.example.model.CCURecord;
import net.spirion.nomadrail.example.model.GPSRecord;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * This class is used to set up test data for the DEV repository.  The process sets up 100 CCUs with random GPS data
 * ready to be used by the DEV example web service.
 * </p>
 * @author Michael Conway
 * @version 1.0
 *
 */
public class CCUCoordinateRepositorySetup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// set the environment profile to dev to mirror the web application setup
		System.setProperty("spring.profiles.active", "dev");
		
		// build the application configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:/net/spirion/nomadrail/example/context/application-context.xml");
		CCUCoordinateRepository repository = (CCUCoordinateRepository) ctx.getBean("cCUCoordinateRepository");
		
		// remove old data
		repository.deleteAll();
		
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
			repository.save(ccu);
		}

	}

}
