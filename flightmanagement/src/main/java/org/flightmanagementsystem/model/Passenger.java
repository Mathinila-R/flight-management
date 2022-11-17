package org.flightmanagementsystem.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="pass_enger")
public class Passenger {
	@Id	
	@Column(name="pnrNumber")
	private BigInteger pnrNumber;
	@Column(name="passengerNumber")
	private String passengerName;
	@Column(name="passengerAge")
	private int passengerAge;
	@Column(name="passengerUIN")
	private BigInteger passengerUIN;
	@Column(name="Luggage")
	private double Luggage;
	public Passenger(BigInteger pnrNumber, String passengerName, int passengerAge, BigInteger passengerUIN,
			double luggage) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		Luggage = luggage;
	}
	public Passenger() {
		super();
		
	}
	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public double getLuggage() {
		return Luggage;
	}
	public void setLuggage(double luggage) {
		Luggage = luggage;
	}
}


	