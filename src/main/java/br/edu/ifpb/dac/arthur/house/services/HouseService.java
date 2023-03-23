package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.repositories.HouseRepository;
import jakarta.transaction.Transactional;
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
    public HouseModel save(HouseModel houseModel) {
        return this.houseRepository.save(houseModel);
    }

    public HouseModel findById(UUID id) throws EntityNotFoundException {
        Optional<HouseModel> houseModelOptional = this.houseRepository.findById(id);
        if(houseModelOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return houseModelOptional.get();
    }

    public List<HouseModel> findAll() {
        return this.houseRepository.findAll();
    }

    public HouseModel update(UUID id, String owner) throws EntityNotFoundException {
        HouseModel houseModel = this.findById(id);
        houseModel.setOwner(owner);
        return this.save(houseModel);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        HouseModel houseModel = this.findById(id);
        this.houseRepository.delete(houseModel);
    }
}
