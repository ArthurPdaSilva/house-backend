package br.edu.ifpb.dac.arthur.house.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_HOUSE")
public class HouseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String owner;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private Float height;
    @Column(nullable = false)
    private Float width;

    @Override
    public String toString() {
        return "HouseModel: \n" +
                "id=" + id +
                ", owner: " + owner + '\'' +
                ", color: " + color + '\'' +
                ", height: " + height +
                ", width: " + width;
    }

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

}
