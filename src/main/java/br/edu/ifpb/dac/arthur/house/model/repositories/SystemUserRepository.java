package br.edu.ifpb.dac.arthur.house.model.repositories;

import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {
}
