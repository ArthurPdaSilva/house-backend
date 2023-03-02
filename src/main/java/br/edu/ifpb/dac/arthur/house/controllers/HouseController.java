package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.repositories.HouseRepository;
import br.edu.ifpb.dac.arthur.house.services.HouseService;
import br.edu.ifpb.dac.arthur.house.utils.ResponseMessage;
import br.edu.ifpb.dac.arthur.house.utils.Validation;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    public void create() throws Exception {
        System.out.println("Ok, Who owns the house?");
        String owner = ResponseMessage.message();

        System.out.println("What's the color?");
        String color = ResponseMessage.message();

        System.out.println("What is the height of the house?");
        Float height = Float.parseFloat(ResponseMessage.message());

        System.out.println("What is the wide of the house?");
        Float width = Float.parseFloat(ResponseMessage.message());

        if(Validation.validationHouse(owner, color, height, width)) {
            var newHouse = new HouseModel();
            newHouse.setOwner(owner);
            newHouse.setColor(color);
            newHouse.setHeight(height);
            newHouse.setWidth(width);
            this.houseService.save(newHouse);
        }

    }

    public void findAllHouses() {
        List<HouseModel> houses = this.houseService.findAll();
        for(HouseModel house: houses ) {
            System.out.println(house);
        }
    }

}
