package net.spirion.nomadrail.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import net.spirion.nomadrail.example.model.CCURecord;
import net.spirion.nomadrail.example.repositories.CCUCoordinateRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Example web service interface implementation defining the methods exposed for the CCU Coordinate service.
 * </p>
 * <p>
 * This implementation uses a Spring Data repository for the data layer.  The advantages here is two-fold:
 * <ul>
 * <li>
 * Spring Data will automatically create the repository boiler-plate code for the common CRUD functions which 
 * should reduce the overall maintenance load for the development team.
 * </li>
 * <li>
 * The data repository is abstracted behind an interface so we could simply swap out the implementation for a different
 * one, for instance JPA with a MySql database, at some point in the future.
 * </li>
 * </ul>
 * </p>
 * 
 * @author Michael Conway
 * @version 0.2
 *
 */
@Service("ccuCoordinateService")
@WebService(serviceName="ccu", name="ccuService")
@Path("/ccuService")
public class CCUCoordinateServiceImpl implements CCUCoordinateService {

	// the logger for this class
	private Logger log = LoggerFactory.getLogger(CCUCoordinateServiceImpl.class);
	
	// the spring data repository pointing at the abstracted data source
	@Autowired private CCUCoordinateRepository repository;
	
	
	@WebMethod
	@GET
	@Produces({"application/json", "text/xml"})
	@Path("/listCoordinates")
	@Override
	public List<CCURecord> listCoordinates() {
		
		log.debug("listing coordinates");
		
		// get all of the ccu Records.  i opted to go directly to the repository here instead of abstracting out to 
		// a "manager" class as the additional code didn't seem worthwhile.  in this case i decided that the level of 
		// abstraction offered by both the repository and the service interfaces was enough to justify dropping the 
		// additional manager abstraction.
		Iterable<CCURecord> i = this.repository.findAll();

		// in almost all cases the iterable will be a list and will be handled gracefully by the jaxb process.  however 
		// i prefer to force the issue here in order to avoid any possibility that the jaxb process will be presented
		// with something it may not be able to handle under the guise of an iterable.
		List<CCURecord> l = new ArrayList<CCURecord>();
		for (CCURecord ccu : i) {
			l.add(ccu);
		}
		
		// return the result. 
		return l;
	}

}