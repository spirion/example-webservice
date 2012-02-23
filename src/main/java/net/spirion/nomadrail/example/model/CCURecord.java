package net.spirion.nomadrail.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * Annotated POJO class used to define the CCU Coordinate Record for the CCU Coordinate Repository.  This class utilises
 * Spring Data to abstract away the underlying data source implementation.  As I'm using Mongo DB as a convenience 
 * rather than setting up the full Hibernate/JPA/MySql stack I am also using a Spring Data MongoDB annotation 
 * (@Document) which will be ignored in all cases except where Spring Data MongoDB component scanning is in force. 
 * </p>
 * 
 * @author Michael Conway
 * @version 0.1
 *
 */
@Document(collection="ccurecord")
@XmlRootElement(name="ccu")
@XmlType(propOrder={"designation", "gps"})
public class CCURecord {

	@SuppressWarnings("unused")
	@Id private String id;
	
	@XmlElement	private String designation;
	@XmlElement private GPSRecord gps;

	/**
	 * No argument constructor for JAXB integration.
	 */
	public CCURecord() {
	}
	
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