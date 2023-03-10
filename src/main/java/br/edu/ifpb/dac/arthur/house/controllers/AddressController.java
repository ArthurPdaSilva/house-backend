package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import br.edu.ifpb.dac.arthur.house.services.AddressService;
import br.edu.ifpb.dac.arthur.house.services.PanelService;
import br.edu.ifpb.dac.arthur.house.services.ValidationService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class AddressController {

    private final AddressService addressService;
    private final PanelService panelService;
    private final ValidationService validationService;

    public AddressController(AddressService addressService, PanelService panelService, ValidationService validationService) {
        this.addressService = addressService;
        this.panelService = panelService;
        this.validationService = validationService;
    }

    public UUID save(String street, String number, String city, String code, String country) throws Exception {
        if(validationService.validationLength(street) || validationService.validationLength(number)) {
            if(validationService.validationLength(city) || validationService.validationLength(country)) {
                if(validationService.validationCode(code)) {
                    AddressModel addressModel = new AddressModel(street, number, city, code, country);
                    return this.addressService.save(addressModel).getId();
                }
            }
        }

        throw new Exception();
    }

    public void findAll() {
        List<AddressModel> addresses = this.addressService.findAll();
        for(AddressModel address: addresses ) {
            this.panelService.print(address.toString());
        }
    }

    public void update(UUID id, String number) throws EntityNotFoundException {
        this.addressService.update(id, number);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        this.addressService.delete(id);
    }
}
