package via.sdj3.slaughterhousepart2.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table
public class Animal
{
  @Id
  @Column
  //@GeneratedValue
  private int registrationNo;
  @Column
  private LocalDate dateOfArrival;
  @Column
  private String name;
  @Column
  private String placeOfOrigin;
  @Column
  private double weight;

  public Animal(int registrationNo, String name, LocalDate dateOfArrival, String placeOfOrigin, double weight) {
    this.registrationNo = registrationNo;
    this.name = name;
    this.dateOfArrival = dateOfArrival;
    this.placeOfOrigin = placeOfOrigin;
    this.weight = weight;
  }

  public Animal()
  {

  }

  public int getRegistrationNo()
  {
    return registrationNo;
  }

  public void setRegistrationNo(int registrationNo)
  {
    this.registrationNo = registrationNo;
  }

  public LocalDate getDateOfArrival()
  {
    return dateOfArrival;
  }

  public void setDateOfArrival(LocalDate dateOfArrival)
  {
    this.dateOfArrival = dateOfArrival;
  }

  public String getPlaceOfOrigin()
  {
    return placeOfOrigin;
  }

  public void setPlaceOfOrigin(String placeOfOrigin)
  {
    this.placeOfOrigin = placeOfOrigin;
  }

  public double getWeight()
  {
    return weight;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
