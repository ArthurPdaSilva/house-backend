package br.edu.ifpb.dac.arthur.house.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ADDRESS")
public class AddressModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String code; 
    @Column(nullable = false)
    private String country;

	public AddressModel() {}

	public AddressModel(String street, String number, String city, String code, String country) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.code = code;
		this.country = country;
	}

	@Override
	public String toString() {
		 return "Address: \n" +
	                "id: " + id +
	                ", street: " + street + '\'' +
	                ", number: " + number + '\'' +
	                ", city:  " + city +
	                ", code: " + code +
	                ", country: " + country + "\n" +
	                "-----------------------------------------------------------------------------------------------------------------------------";
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
