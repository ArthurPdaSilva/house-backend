package br.edu.ifpb.dac.arthur.house.model.repositories;

import br.edu.ifpb.dac.arthur.house.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
