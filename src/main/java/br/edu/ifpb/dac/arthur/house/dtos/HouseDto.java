package br.edu.ifpb.dac.arthur.house.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class HouseDto {

    @NotBlank
    @Size(min = 4, max = 50)
    private String owner;
    @NotBlank
    private String color;

    @NotNull
    private Float height;

    @NotNull
    private Float width;

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
}
