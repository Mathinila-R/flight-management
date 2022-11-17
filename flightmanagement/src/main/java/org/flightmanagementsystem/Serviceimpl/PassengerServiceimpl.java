package org.flightmanagementsystem.Serviceimpl;

import java.math.BigInteger;
import java.util.List;

import org.flightmanagementsystem.Exception.ResourceNotFoundException;
import org.flightmanagementsystem.Repository.PassengerRepository;
import org.flightmanagementsystem.Service.PassengerService;
import org.flightmanagementsystem.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceimpl implements PassengerService {
	//dependency injection
	@Autowired
	private  PassengerRepository passengerRepository;
	//constructor injection
	public PassengerServiceimpl(PassengerRepository passengerRepository) {
		super();
		this.passengerRepository = passengerRepository;
	}
	//addPassenger method
	@Override
	public Passenger savePassenger(Passenger passenger) {
		
		return passengerRepository.save(passenger);
	}
	//findAll
	@Override
	public List<Passenger> getAllPassenger() {
		
		return passengerRepository.findAll();
	}
	//findById
	@Override
	public Passenger getPassengerById(BigInteger pnrNumber) {
		return passengerRepository.findById(pnrNumber).orElseThrow(()->
		new ResourceNotFoundException("Passenger","PnrNumber",pnrNumber));
	}
	@Override
	public Passenger updatePassenger(Passenger passenger, BigInteger pnrNumber) {   
		Passenger full=passengerRepository.findById(pnrNumber).orElseThrow(()->
		new ResourceNotFoundException("Passenger","PnrNumber",pnrNumber));
		
		full.setPassengerName(passenger.getPassengerName());
		full.setPassengerUIN(passenger.getPassengerUIN());
		full.setPassengerAge(passenger.getPassengerAge());
		full.setLuggage(passenger.getLuggage());
		return  passengerRepository.save(full);
	}
	@Override
	public void deletePassenger(BigInteger pnrNumber) {
	    passengerRepository.findById(pnrNumber).orElseThrow(()->
		new ResourceNotFoundException("Passenger","PnrNumber",pnrNumber));     
	    passengerRepository.deleteById(pnrNumber);
		
	}

		
		
	}
	
	
	
	
	

