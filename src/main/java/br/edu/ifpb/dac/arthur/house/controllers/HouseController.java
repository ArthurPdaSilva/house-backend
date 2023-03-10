package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.services.AddressService;
import br.edu.ifpb.dac.arthur.house.services.HouseService;
import br.edu.ifpb.dac.arthur.house.services.PanelService;
import br.edu.ifpb.dac.arthur.house.services.ValidationService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class HouseController {

    private final HouseService houseService;
    private final AddressService addressService;
    private final PanelService panelService;

    private final ValidationService validationService;

    public HouseController(HouseService houseService, AddressService addressService, PanelService panelService, ValidationService validationService) {
        this.houseService = houseService;
        this.addressService = addressService;
        this.panelService = panelService;
        this.validationService = validationService;
    }

    public void save(String owner, String color, String height, String width, UUID addressId) throws Exception {
        Float heightFormatter = Float.parseFloat(height);
        Float widthFormatter = Float.parseFloat(width);

        if(validationService.validationLength(color) || validationService.validationLength(owner)) {
            if(validationService.validationSize(heightFormatter, widthFormatter)) {
                HouseModel houseModel = new HouseModel(owner, color, heightFormatter, widthFormatter);
                AddressModel addressModel = this.addressService.findById(addressId);
                houseModel.setAddress(addressModel);
                this.houseService.save(houseModel);
            }
        }
    }

    public void findAll() {
        List<HouseModel> houses = this.houseService.findAll();
        for(HouseModel house: houses) {
            this.panelService.print(house.toString());
        }
    }

    public void update(UUID id, String owner) throws EntityNotFoundException {
        this.houseService.update(id, owner);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        this.houseService.delete(id);
    }
}
