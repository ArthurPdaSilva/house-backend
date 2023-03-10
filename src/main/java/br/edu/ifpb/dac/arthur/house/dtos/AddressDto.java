package br.edu.ifpb.dac.arthur.house.dtos;

import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class AddressDto {

    private UUID id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String street;
    @NotBlank
    @Size(min = 2, max = 30)
    private String number;
    @NotBlank
    @Size(min = 2, max = 50)
    private String city;
    @NotBlank
    @Size(min = 8, max = 8)
    private String code;
    @NotBlank
    @Size(min = 2, max = 50)
    private String country;


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
