package br.edu.ifpb.dac.arthur.house.model.repositories;

import br.edu.ifpb.dac.arthur.house.model.entities.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SystemRoleRepository extends JpaRepository<SystemRole, UUID> {
}
