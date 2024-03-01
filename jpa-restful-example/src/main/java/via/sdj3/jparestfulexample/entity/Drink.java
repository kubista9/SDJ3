package via.sdj3.jparestfulexample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Drink {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private double unityPrice;
	@Column
	private int quantity;

	public Drink(int id, String name, String description, double unityPrice, int quantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.unityPrice = unityPrice;
		this.quantity = quantity;
	}

	public Drink() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnityPrice() {
		return unityPrice;
	}

	public void setUnityPrice(double unityPrice) {
		this.unityPrice = unityPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
