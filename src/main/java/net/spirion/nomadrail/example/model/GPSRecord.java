package net.spirion.nomadrail.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Convenience POJO used to hold GPS data for the CCU Record.
 * </p>
 * @author Michael Conway
 * @version 0.1
 *
 */
@XmlType(name= "gps", propOrder={"bearing", "latitude", "longitude", "sats", "speed"})
public class GPSRecord {

	@XmlElement private Integer bearing;
	@XmlElement private Double latitude;
	@XmlElement private Double longitude;
	@XmlElement private Integer sats;
	@XmlElement private Integer speed;
	
	/**
	 * No argument constructor for JAXB integration.
	 */
	public GPSRecord() {
	}
	
	/**
	 * Constructor utilising all properties.
	 * @param bearing
	 * @param latitude
	 * @param longitude
	 * @param sats
	 * @param speed
	 */
	public GPSRecord(Integer bearing, Double latitude, Double longitude, Integer sats, Integer speed) {
		this.bearing = bearing;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sats = sats;
		this.speed = speed;
	}

	public Integer getBearing() {
		return bearing;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Integer getSats() {
		return sats;
	}

	public Integer getSpeed() {
		return speed;
	}
	
}