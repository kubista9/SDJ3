package via.sdj3.grpcspringboot.frontend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Animal {
	@Column
	private Date arrivalDate;
	@Column
	private double weight;
	@Id
	@Column
	private int registrationNumber;
	@Column
	private String farm;

	public Animal(){

	}

	public Animal(Date arrivalDate, double weight, int registrationNumber, String farm) {
		this.arrivalDate = arrivalDate;
		this.weight = weight;
		this.registrationNumber = registrationNumber;
		this.farm = farm;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}
}
