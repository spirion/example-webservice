package net.spirion.nomadrail.example.context.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * Annotated POJO class used to define the CCU Coordinate Record for the CCU Coordinate Repository.  This class utilises
 * Spring Data to abstract away the underlying data source implementation.  As I'm using Mongo DB as a convenience 
 * rather than setting up the full Hibernate/JPA/MySql stack I are also a String Data MongoDB annotation (@Document)
 * which will be ignored in all cases except where Spring Data MongoDB component scanning is in force. 
 * </p>
 * 
 * @author Michael Conway
 * @version 0.1
 *
 */
@Document(collection="ccurecord")
public class CCURecord {

	@SuppressWarnings("unused")
	@Id private String id;
	
	private String designation;
	private GPSRecord gps;
	
	/**
	 * Constructor utilising all properties.
	 * @param designation
	 * @param gps
	 */
	public CCURecord(String designation, GPSRecord gps) {
		this.designation = designation;
		this.gps = gps;
	}

	public String getDesignation() {
		return designation;
	}

	public GPSRecord getGps() {
		return gps;
	}
	
}