package br.edu.ifpb.dac.arthur.house.repositories;

import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, UUID> {
}
