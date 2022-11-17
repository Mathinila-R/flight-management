package org.flightmanagementsystem.Repository;

import org.flightmanagementsystem.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	

}
