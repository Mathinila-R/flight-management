package org.flightmanagementsystem.Service;

import java.util.List;

import org.flightmanagementsystem.model.Airport;

public interface AirportService {
	//Save the id,Airport Name,Airport Code,Airport Location
	Airport saveAirport(Airport airport);
	//To FindAll
	List<Airport>getAllAirports();
	//findByAirportcode
     Airport getAirportByAirportCode(long airportCode);
	//update
	Airport updateAirport(Airport airport,long airportCode);
	//Delete
	void deleteAirport(long airportCode);
}
