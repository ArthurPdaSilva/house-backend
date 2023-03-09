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


    public Optional<HouseModel> findById(UUID id) {
        return this.houseRepository.findById(id);
    }

    public List<HouseModel> findAll() {
        return this.houseRepository.findAll();
    }

    public void save(String owner, String color, Float height, Float width, AddressModel addressModel) {
        HouseModel houseModel = new HouseModel(owner, color, height, width, addressModel);
        houseRepository.save(houseModel);
    }
}
