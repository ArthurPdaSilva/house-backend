package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import br.edu.ifpb.dac.arthur.house.services.AddressService;
import br.edu.ifpb.dac.arthur.house.services.PanelService;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class AddressController {

    private final AddressService addressService;
    private final PanelService panelService;

    public AddressController(AddressService addressService, PanelService panelService) {
        this.addressService = addressService;
        this.panelService = panelService;
    }

    public AddressModel create(String street, String number, String city, String code, String country) throws Exception {
        return  addressService.save(street, number, city, code, country);
    }

    public void findAllAddress() {
        List<AddressModel> addresses = this.addressService.findAll();
        for(AddressModel address: addresses ) {
            panelService.print(address.toString());
        }
    }
}
