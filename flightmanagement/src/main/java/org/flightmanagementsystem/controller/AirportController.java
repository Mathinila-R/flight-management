package org.flightmanagementsystem.controller;

import java.util.List;

import org.flightmanagementsystem.Service.AirportService;
import org.flightmanagementsystem.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight/airports")
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	
	public AirportController(AirportService airportService) {
		super();
		this.airportService = airportService;
	}

	//create airport REST API
		@PostMapping()
		public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport){
			return new ResponseEntity<Airport>(airportService.saveAirport(airport),
					HttpStatus.CREATED);
		}
		@GetMapping
		public List<Airport>getAllAirport(){
			return airportService.getAllAirports();
		}
		@GetMapping("{airportCode}")
		public ResponseEntity<Airport>getAirportByairportCode(@PathVariable("airportCode") long airportCode){
			return new ResponseEntity<Airport>(airportService.getAirportByAirportCode( airportCode),
					HttpStatus.OK);
		}
		@PutMapping("{airportCode}")
		public ResponseEntity<Airport>updateAirport(@PathVariable("airportCode" )long airportCode,
				@RequestBody Airport airport){
			return new ResponseEntity<Airport>
			(airportService.updateAirport(airport,airportCode),HttpStatus.OK);
		}
		@DeleteMapping("{airportCode}")	
		public ResponseEntity<String>deleteAirport(@PathVariable("airportCode")long airportCode){
			//delete airport
			airportService.deleteAirport(airportCode);
			return new ResponseEntity<String>("Airport delete successfully.",HttpStatus.OK);
}
}

