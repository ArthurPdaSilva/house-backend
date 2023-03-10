package br.edu.ifpb.dac.arthur.house.dtos;

import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class HouseDto {

    @NotBlank
    @Size(min = 4, max = 50)
    private String owner;
    @NotBlank
    private String color;
    @NotBlank
    @DecimalMin(value = "0.0", inclusive = false)
    private Float height;
    @NotBlank
    @DecimalMin(value = "0.0", inclusive = false)
    private Float width;

    @NotBlank
    private AddressModel address;

    @Override
    public String toString() {
        return "House: \n" +
                ", owner: " + owner + '\'' +
                ", color: " + color + '\'' +
                ", height: " + height +
                ", width: " + width +
                ", Address_ID: " + address.getId() + "\n" +
                "----------------------------------------------------------------------------------------------------------------------";
    }

    public HouseDto() {}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
