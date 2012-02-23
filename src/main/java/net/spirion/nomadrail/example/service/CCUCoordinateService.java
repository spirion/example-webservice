package net.spirion.nomadrail.example.service;

import java.util.List;

import net.spirion.nomadrail.example.model.CCURecord;

/**
 * <p>
 * Service interface defining the methods exposed for the CCU Coordinate service.
 * </p>
 * @author Michael Conway
 * @version 0.1
 *
 */

public interface CCUCoordinateService {

	/**
	 * List the coordinates of all CCUs known to the system.
	 * @return A list of <code>CCURecord</code> objects
	 * @throws ServiceException Optional depending on implementation
	 */
	public List<CCURecord> listCoordinates() throws ServiceException;
		
}