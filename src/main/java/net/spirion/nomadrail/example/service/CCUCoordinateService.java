package net.spirion.nomadrail.example.service;

import javax.jws.WebService;

/**
 * <p>
 * Example web service interface defining the methods exposed for the CCU Coordinate service.
 * </p>
 * @author Michael Conway
 * @version 0.1
 *
 */
@WebService
public interface CCUCoordinateService {

	/**
	 * List the coordinates of all CCUs known to the system.
	 * @return A simple JSON encoded string of all available CCUs
	 * @throws ServiceException
	 */
	public String listCoordinates() throws ServiceException;
		
}