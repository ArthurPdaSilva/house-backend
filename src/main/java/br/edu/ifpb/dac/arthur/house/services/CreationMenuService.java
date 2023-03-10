package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.controllers.AddressController;
import br.edu.ifpb.dac.arthur.house.controllers.HouseController;
import org.springframework.stereotype.Service;

@Service
public class CreationMenuService {

    private final MessageService messageService;
    private final  PanelService panelService;

    public CreationMenuService(MessageService messageService, PanelService panelService, AddressController addressController, HouseController houseController) {
        this.messageService = messageService;
        this.panelService = panelService;
    }

    public String[] creationAddress() throws Exception {
        panelService.print("First, what is the street?");
        String street = messageService.getResponse();

        panelService.print("What is the number?");
        String number = messageService.getResponse();

        panelService.print("What is the city?");
        String city = messageService.getResponse();

        panelService.print("What is the zip?");
        String code = messageService.getResponse();

        panelService.print("What is the country?");
        String country = messageService.getResponse();

        return new String[]{street, number, city, code, country};
    }

    public String[] creationHouse() throws Exception {
        panelService.print("Ok, Who owns the house?");
        String owner = messageService.getResponse();

        panelService.print("What's the color?");
        String color = messageService.getResponse();

        panelService.print("What is the height of the house?");
        String height = messageService.getResponse();

        panelService.print("What is the wide of the house?");
        String width = messageService.getResponse();

        return new String[]{owner, color, height, width};
    }
}
