package br.edu.ifpb.dac.arthur.house.model.entities;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "TB_ROLE")
public class SystemRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public SystemRole(){}


    @Override
    public String getAuthority() {
        return this.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
