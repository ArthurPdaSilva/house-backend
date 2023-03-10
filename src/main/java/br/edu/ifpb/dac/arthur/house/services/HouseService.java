package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.repositories.HouseRepository;
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

    public void save(HouseModel houseModel) {
        this.houseRepository.save(houseModel);
    }

    public HouseModel findById(UUID id) {
        Optional<HouseModel> houseModelOptional = this.houseRepository.findById(id);
        return houseModelOptional.get();
    }

    public List<HouseModel> findAll() {
        return this.houseRepository.findAll();
    }

    public void update(UUID id, String owner) {
        HouseModel houseModel = this.findById(id);
        houseModel.setOwner(owner);
        this.save(houseModel);
    }

    public void delete(UUID id) {
        HouseModel houseModel = this.findById(id);
        this.houseRepository.delete(houseModel);
    }
}
