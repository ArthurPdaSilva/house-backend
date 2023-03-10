package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.services.HouseService;
import br.edu.ifpb.dac.arthur.house.services.PanelService;
import br.edu.ifpb.dac.arthur.house.services.ValidationHouseService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HouseController {

    private final HouseService houseService;
    private final PanelService panelService;

    private final ValidationHouseService validationHouseService;

    public HouseController(HouseService houseService, PanelService panelService, ValidationHouseService validationHouseService) {
        this.houseService = houseService;
        this.panelService = panelService;
        this.validationHouseService = validationHouseService;
    }

    public void findAllHouses() {
        List<HouseModel> houses = this.houseService.findAll();
        for(HouseModel house: houses ) {
            this.panelService.print(house.toString());
        }
    }

    public void save(String owner, String color, Float height, Float width, AddressModel addressModel) throws Exception {
        if(validationHouseService.validationColor(color) || validationHouseService.validationOwner(owner)) {
            if(validationHouseService.validationSize(height, width)) {
                HouseModel houseModel = new HouseModel(owner, color, height, width);
                houseModel.setAddress(addressModel);
                this.houseService.save(houseModel);
            }
        }
    }
}
