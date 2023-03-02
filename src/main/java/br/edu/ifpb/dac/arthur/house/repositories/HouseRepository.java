package br.edu.ifpb.dac.arthur.house.repositories;

import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HouseRepository extends JpaRepository<HouseModel, UUID> {
}
