package net.spirion.nomadrail.example.repositories;

import java.util.List;

import net.spirion.nomadrail.example.context.model.CCURecord;

import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 * This is a Spring Data extended <code>CrudRepostiory</code> used to define the basic CRUD operations for the 
 * CCU Coordinate repository.
 * </p>
 * 
 * @author Michael Conway
 * @Version 0.1
 *
 */
public interface CCUCoordinateRepository extends CrudRepository<CCURecord, String> {
	
	/**
	 * An example method showing how to instruct Spring Data to create the boiler-plate code for a basic finder
	 * method on an existing property. 
	 * @param designation
	 * @return A list of CCURecord objects matching the designation
	 */
	public List<CCURecord> findByDesignation(String designation);
	
}