package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.model.entities.House;
import br.edu.ifpb.dac.arthur.house.model.repositories.HouseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Transactional
    public House save(House house) {
        return this.houseRepository.save(house);
    }

    public House findById(UUID id) throws EntityNotFoundException {
        Optional<House> houseModelOptional = this.houseRepository.findById(id);
        if(houseModelOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return houseModelOptional.get();
    }

    public Page<House> findAll(Pageable pageable) {
        return this.houseRepository.findAll(pageable);
    }

    public House update(UUID id, String owner) throws EntityNotFoundException {
        House house = this.findById(id);
        house.setOwner(owner);
        return this.save(house);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        House house = this.findById(id);
        this.houseRepository.delete(house);
    }
}
