package br.edu.ifpb.dac.arthur.house.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

public class SystemRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    public SystemRole(){}


    @Override
    public String getAuthority() {
        return this.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
