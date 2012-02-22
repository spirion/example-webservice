package net.spirion.nomadrail.example.context.model;

/**
 * <p>
 * Convenience POJO used to define GPS data for the CCU Record.
 * </p>
 * @author Michael Conway
 * @version 0.1
 *
 */
public class GPSRecord {

	private Integer bearing;
	private Double latitude;
	private Double longitude;
	private Integer sats;
	private Integer speed;
	
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