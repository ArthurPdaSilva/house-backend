package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.dtos.AddressDto;
import br.edu.ifpb.dac.arthur.house.dtos.HouseDto;
import br.edu.ifpb.dac.arthur.house.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.services.AddressService;
import br.edu.ifpb.dac.arthur.house.services.HouseService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class HouseController {

    private final HouseService houseService;
    private final AddressService addressService;


    public HouseController(HouseService houseService, AddressService addressService) {
        this.houseService = houseService;
        this.addressService = addressService;
    }

    public void save(@Valid HouseDto houseDto, UUID id) throws EntityNotFoundException {
        var houseModel = new HouseModel();
        var addressModel = this.addressService.findById(id);
        BeanUtils.copyProperties(houseDto, houseModel);
        houseModel.setAddress(addressModel);
        this.houseService.save(houseModel);
    }

    public List<HouseDto> findAll() {
        List<HouseModel> houses = this.houseService.findAll();
        List<HouseDto> housesDtos = new ArrayList<>();

        for(HouseModel house: houses ) {
            var houseDto = new HouseDto();
            BeanUtils.copyProperties(house, houseDto);
            housesDtos.add(houseDto);
        }

        return housesDtos;
    }

    public void update(UUID id, String owner) throws EntityNotFoundException {
        this.houseService.update(id, owner);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        this.houseService.delete(id);
    }
}
