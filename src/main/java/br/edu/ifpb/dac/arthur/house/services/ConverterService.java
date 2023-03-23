package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.dtos.HouseDto;
import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public HouseModel dtoToHouseModel(HouseDto houseDto) {
        var houseModel = new HouseModel();
        BeanUtils.copyProperties(houseDto, houseModel);
        return houseModel;
    }
}
