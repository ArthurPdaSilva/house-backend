package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.dtos.AddressDto;
import br.edu.ifpb.dac.arthur.house.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import br.edu.ifpb.dac.arthur.house.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public UUID save(@Valid AddressDto addressDto) {
        var addressModel = new AddressModel();
        BeanUtils.copyProperties(addressDto, addressModel);
        return this.addressService.save(addressModel).getId();
    }

    public List<AddressDto> findAll() {
        List<AddressModel> addresses = this.addressService.findAll();
        List<AddressDto> addressDtos = new ArrayList<>();

        for(AddressModel address: addresses ) {
            var addressDto = new AddressDto();
            BeanUtils.copyProperties(address, addressDto);
            addressDtos.add(addressDto);
        }
        
        return addressDtos;
    }

    public AddressDto findById(UUID id) throws EntityNotFoundException {
        var addressDto = new AddressDto();
        var addressModel = this.addressService.findById(id);
        BeanUtils.copyProperties(addressModel, addressDto);
        return addressDto;
    }

    public void update(UUID id, String number) throws EntityNotFoundException {
        this.addressService.update(id, number);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        this.addressService.delete(id);
    }
}
