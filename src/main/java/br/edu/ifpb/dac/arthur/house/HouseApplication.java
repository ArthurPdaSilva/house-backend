package br.edu.ifpb.dac.arthur.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HouseApplication {
	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Conectado ao servidor!";
	}

}
