package org.flightmanagementsystem.Serviceimpl;

import java.math.BigInteger;
import java.util.List;

import org.flightmanagementsystem.Exception.ResourceNotFoundException;
import org.flightmanagementsystem.Repository.FlightRepository;
import org.flightmanagementsystem.Service.FlightService;
import org.flightmanagementsystem.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService{
	
	

	@Autowired
	private FlightRepository flightRepository;

	
	
	//constructor
	public FlightServiceImpl(FlightRepository flightRepository) {
		super();
		this.flightRepository = flightRepository;
	}




	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepository.save(flight);
	}




	@Override
	public Flight modifyFlight(Flight flight, BigInteger id) {
		Flight object = flightRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flight" , "Id",id));
		object.setCarrierName(flight.getCarrierName());
		object.setFlightModel(flight.getFlightModel());
		object.setSeatCapacity(flight.getSeatCapacity());
		flightRepository.save(object);
		return object;
	}


	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		
		return flightRepository.findById(flightNumber).orElseThrow(() -> 
		new ResourceNotFoundException ("Flight", "Id", flightNumber) );
	}

	@Override
	public List<Flight> viewAllFlight() {
        return flightRepository.findAll();
    }

	@Override
	public Flight deleteFlight(BigInteger flightNumber) {
		 Flight del = flightRepository.findById(flightNumber).orElseThrow( ()->
		 new ResourceNotFoundException("Flight","Id",flightNumber));
		 flightRepository.deleteById(flightNumber);
		 return del;
	        
	    }




	
	
	

}

