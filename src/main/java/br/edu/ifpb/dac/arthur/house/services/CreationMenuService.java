package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.controllers.AddressController;
import br.edu.ifpb.dac.arthur.house.controllers.HouseController;
import br.edu.ifpb.dac.arthur.house.dtos.AddressDto;
import br.edu.ifpb.dac.arthur.house.dtos.HouseDto;
import org.springframework.stereotype.Service;

@Service
public class CreationMenuService {

    private final MessageService messageService;
    private final  PanelService panelService;

    public CreationMenuService(MessageService messageService, PanelService panelService, AddressController addressController, HouseController houseController) {
        this.messageService = messageService;
        this.panelService = panelService;
    }

    public AddressDto creationAddress() {
        AddressDto addressDto = new AddressDto();

        panelService.print("First, what is the street?");
        addressDto.setStreet(messageService.getResponse());

        panelService.print("What is the number?");
        addressDto.setNumber(messageService.getResponse());

        panelService.print("What is the city?");
        addressDto.setCity(messageService.getResponse());

        panelService.print("What is the zip?");
        addressDto.setCode(messageService.getResponse());

        panelService.print("What is the country?");
        addressDto.setCountry(messageService.getResponse());

        return addressDto;
    }

    public HouseDto creationHouse() {
        HouseDto houseDto = new HouseDto();

        panelService.print("Ok, Who owns the house?");
        houseDto.setOwner(messageService.getResponse());

        panelService.print("What's the color?");
        houseDto.setColor(messageService.getResponse());

        panelService.print("What is the height of the house?");
        houseDto.setHeight(Float.parseFloat(messageService.getResponse()));

        panelService.print("What is the wide of the house?");
        houseDto.setWidth(Float.parseFloat(messageService.getResponse()));

        return houseDto;
    }
}
