package br.edu.ifpb.dac.arthur.house.model.repositories;

import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {
    Optional<SystemUser> findByUsername(String username);
    Optional<SystemUser> findByEmail(String  email);
}
