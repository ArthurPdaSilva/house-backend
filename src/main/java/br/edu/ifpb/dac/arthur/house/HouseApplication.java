package br.edu.ifpb.dac.arthur.house;

import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class HouseApplication implements CommandLineRunner {


	@Autowired
	private SystemRoleService systemRoleService;

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		systemRoleService.createDefaultValues();
	}
}
