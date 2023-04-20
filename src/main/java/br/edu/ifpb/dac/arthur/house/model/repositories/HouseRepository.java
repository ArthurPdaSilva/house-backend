package br.edu.ifpb.dac.arthur.house.model.repositories;

import br.edu.ifpb.dac.arthur.house.model.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
