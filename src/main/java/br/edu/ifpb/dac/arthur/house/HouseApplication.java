package br.edu.ifpb.dac.arthur.house;

import br.edu.ifpb.dac.arthur.house.controllers.AddressController;
import br.edu.ifpb.dac.arthur.house.controllers.HouseController;
import br.edu.ifpb.dac.arthur.house.services.MessageService;
import br.edu.ifpb.dac.arthur.house.services.PanelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouseApplication implements CommandLineRunner {

	private final HouseController houseController;
	private final AddressController addressController;

	private final MessageService messageService;
	private final PanelService panelService;

	public HouseApplication(HouseController houseController, AddressController addressController, MessageService messageService, PanelService panelService) {
		this.houseController = houseController;
		this.addressController = addressController;
		this.messageService = messageService;
		this.panelService = panelService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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

						panelService.print("Ok, Who owns the house?");
						String owner = messageService.getResponse();

						panelService.print("What's the color?");
						String color = messageService.getResponse();

						panelService.print("What is the height of the house?");
						Float height = Float.parseFloat(messageService.getResponse());

						panelService.print("What is the wide of the house?");
						Float width = Float.parseFloat(messageService.getResponse());

						houseController.save(owner, color, height, width, addressController.create(street, number, city, code, country));

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
