package net.spirion.nomadrail.example.service;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import net.spirion.nomadrail.example.context.model.CCURecord;
import net.spirion.nomadrail.example.repositories.CCUCoordinateRepository;

import org.codehaus.jackson.map.ObjectMapper;
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
 * on at some point in the future.
 * </li>
 * </ul>
 * </p>
 * 
 * @author Michael Conway
 * @version 0.1
 *
 */
@WebService(endpointInterface = "net.spirion.nomadrail.example.service.CCUCoordinateService")
@Service("ccuCoordinateService")
public class CCUCoordinateServiceImpl implements CCUCoordinateService {

	// the logger for this class
	private Logger log = LoggerFactory.getLogger(CCUCoordinateServiceImpl.class);
	
	// the spring data repository pointing at the abstracted data source
	@Autowired private CCUCoordinateRepository repository;
	
	// json object mapper.
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String listCoordinates() throws ServiceException {
		
		// get all of the ccu Records.  i opted to go directly to the repository here instead of abstracting out the 
		// a manager class as the additional code didn't seem worthwhile.  in this case i decided that the level of 
		// abstraction offered by both the repository and the service interfaces was enough to justify dropping the 
		// additional manager abstraction.
		Iterable<CCURecord> i = this.repository.findAll();
		
		// place ccu records into a map for an element named "ccu" to enable correct marshalling of the result by the 
		// json mapper.  this is done specifically to enable the default object mapper to marshal the json in the same
		// way as described by the specification document.  if any further fine tuning was required then the the jackson 
		// json libraries allow for an object mapping abstraction which could be used accordingly.  
		Map<String, Iterable<CCURecord>> m = new HashMap<String, Iterable<CCURecord>>();
		m.put("ccus", i);

		// convert the result map to json.  this process utilises the jackson json ObjectMapper defined globally for
		// this singleton.  as the ObjectMappper is thread safe there is no need to define a new instance each time
		// the method is called.
		String json = null;
		try {
			json = mapper.writeValueAsString(m);
			
			// there is a need to catch and handle exception here.  as i am not familiar with the exception handling
			// methods used by nomad i have opted to simply enclose the thrown exception in a ServiceException and throw
			// that, allowing the apache cxf framework to handle the result.
			
		} catch (Exception e) {
			// log the error
			this.log.warn("Unexpected error occurred", e);
			
			// throw the exception, i'd expect something a little more graceful here which conforms to whatever
			// exception handling methods are in use
			throw new ServiceException("Error marshalling JSON object", e);
			
		}
		
		// return the result. i have opted to simply return the json string from this service method.  i suspect that 
		// the apache cxf framework allows for the translation of return values when marshalling the resulting soap
		// body, however i opted to keep this simple.
		return json;
		
	}

}