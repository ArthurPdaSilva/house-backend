package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.model.entities.Address;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.AddressDto;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.HouseDto;
import br.edu.ifpb.dac.arthur.house.model.entities.House;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public House dtoToHouseModel(HouseDto houseDto) {
        var houseModel = new House();
        BeanUtils.copyProperties(houseDto, houseModel);
        return houseModel;
    }

    public Address dtoToAddressModel(AddressDto addressDto) {
        var addressModel = new Address();
        BeanUtils.copyProperties(addressDto, addressModel);
        return addressModel;
    }
}
