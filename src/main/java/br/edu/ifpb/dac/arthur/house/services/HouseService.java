package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public void save(HouseModel newHouse) {
        this.houseRepository.save(newHouse);
    }

    public List<HouseModel> findAll() {
        return this.houseRepository.findAll();
    }
}
