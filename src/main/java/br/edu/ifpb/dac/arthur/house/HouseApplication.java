package br.edu.ifpb.dac.arthur.house;

import br.edu.ifpb.dac.arthur.house.controllers.AddressController;
import br.edu.ifpb.dac.arthur.house.controllers.HouseController;
import br.edu.ifpb.dac.arthur.house.services.CreationMenuService;
import br.edu.ifpb.dac.arthur.house.services.MessageService;
import br.edu.ifpb.dac.arthur.house.services.PanelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class HouseApplication implements CommandLineRunner {

	private final HouseController houseController;
	private final AddressController addressController;

	private final MessageService messageService;
	private final PanelService panelService;
	private final CreationMenuService creationMenuService;

	public HouseApplication(HouseController houseController, AddressController addressController, MessageService messageService, PanelService panelService, CreationMenuService creationMenuService) {
		this.houseController = houseController;
		this.addressController = addressController;
		this.messageService = messageService;
		this.panelService = panelService;
		this.creationMenuService = creationMenuService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@Override
	public void run(String... args) {
		boolean isOver = false;
		String menu = "\n" + """
			1 - Listing of houses
			2 - Listing of address
			3 - Registration of houses
			4 - Stop
			""";

		panelService.print("Hello, welcome to the application :)");
		while (!isOver) {
			panelService.print(menu);
			var optionSelected = messageService.getResponse();

			switch (optionSelected) {
				case "1" -> houseController.findAllHouses();
				case "2" -> addressController.findAllAddress();
				case "3" -> {
					try {
						String[] addressAttributes = this.creationMenuService.creationAddress();
						UUID addressId = this.addressController.create(addressAttributes[0], addressAttributes[1],
								addressAttributes[2], addressAttributes[3], addressAttributes[4]);

						String[] houseAttributes = this.creationMenuService.creationHouse();
						this.houseController.save(houseAttributes[0], houseAttributes[1],
								houseAttributes[2], houseAttributes[3], addressId );

						panelService.print("Successfully registered!");
					} catch (Exception e) {
						panelService.printError(e.getMessage());
					}
				}
				case "4" -> {
					panelService.print("It's over.");
					isOver = true;
				}
				default -> panelService.print("Invalid option!");
			}
		}

	}
}
