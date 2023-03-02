package br.edu.ifpb.dac.arthur.house;

import br.edu.ifpb.dac.arthur.house.controllers.HouseController;
import br.edu.ifpb.dac.arthur.house.utils.ResponseMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouseApplication implements CommandLineRunner {

	private final HouseController houseController;

	public HouseApplication(HouseController houseController) {
		this.houseController = houseController;
	}

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean isOver = false;
		String menu = "\n" + """
			1 - Listing of houses
			2 - Registration of houses
			3 - Stop
			""";

		System.out.println("Hello, welcome to the application :)");

		while (!isOver) {
			System.out.println(menu);
			var optionSelected = ResponseMessage.message();

			switch (optionSelected) {
				case "1" -> houseController.findAllHouses();
				case "2" -> {
					try {
						houseController.create();
						System.out.println("Successfully registered!");
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
				case "3" -> {
					System.out.println("It's over.");
					isOver = true;
				}
				default -> System.out.println("Invalid option!");
			}
		}

	}
}
