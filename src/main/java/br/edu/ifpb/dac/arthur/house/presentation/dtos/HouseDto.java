package br.edu.ifpb.dac.arthur.house.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class HouseDto {

    private UUID id;

    @NotBlank
    @Size(min = 4, max = 50)
    private String owner;
    @NotBlank
    private String color;
    @NotNull
    private Float height;
    @NotNull
    private Float width;
    @NotNull
    private UUID addressId;

    public HouseDto() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }
}
