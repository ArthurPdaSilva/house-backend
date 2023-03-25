package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.model.entities.Address;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.AddressDto;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.HouseDto;
import br.edu.ifpb.dac.arthur.house.model.entities.House;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterService {

    public House dtoToHouseModel(HouseDto houseDto) {
        var houseModel = new House();
        BeanUtils.copyProperties(houseDto, houseModel);
        return houseModel;
    }

    public HouseDto HouseModelToDto(House house) {
        var houseDto = new HouseDto();
        BeanUtils.copyProperties(house, houseDto);
        houseDto.setAddressId(house.getAddress().getId());
        return houseDto;
    }

    public List<HouseDto> housesModelToDtos(List<House> houses) {
        List<HouseDto> housesDto = new ArrayList<>();
        for(House house: houses) {
            HouseDto houseDto = this.HouseModelToDto(house);
            housesDto.add(houseDto);
        }

        return housesDto;
    }

    public Address dtoToAddressModel(AddressDto addressDto) {
        var addressModel = new Address();
        BeanUtils.copyProperties(addressDto, addressModel);
        return addressModel;
    }

    public AddressDto AddressModelToDto(Address address) {
        var addressDto = new AddressDto();
        BeanUtils.copyProperties(address, addressDto);
        return addressDto;
    }
}
