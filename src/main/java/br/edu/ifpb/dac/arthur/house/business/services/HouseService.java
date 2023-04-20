package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.model.entities.House;
import br.edu.ifpb.dac.arthur.house.model.repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public House save(House house) {
        return this.houseRepository.save(house);
    }

    public House findById(Long id) throws EntityNotFoundException {
        Optional<House> houseModelOptional = this.houseRepository.findById(id);
        if(houseModelOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return houseModelOptional.get();
    }

    public List<House> findAll() {
        return this.houseRepository.findAll();
    }

    public House update(Long id, String owner) throws EntityNotFoundException {
        House house = this.findById(id);
        house.setOwner(owner);
        return this.save(house);
    }

    public void delete(Long id) throws EntityNotFoundException {
        House house = this.findById(id);
        this.houseRepository.delete(house);
    }
}
