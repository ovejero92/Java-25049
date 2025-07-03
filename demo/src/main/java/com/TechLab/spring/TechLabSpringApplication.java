package com.TechLab.spring;
import com.TechLab.spring.model.Role;
import com.TechLab.spring.model.Usuario;
import com.TechLab.spring.repository.RoleRepository;
import com.TechLab.spring.repository.UserRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class TechLabSpringApplication {

	public static void main(String[] args) {
		// Cargar el archivo .env y setear la variable en el entorno del sistema
		Dotenv dotenv = Dotenv.load();
		String dbPassword = dotenv.get("SPRING_DATASOURCE_PASSWORD");

		if (dbPassword != null) {
			System.setProperty("SPRING_DATASOURCE_PASSWORD", dbPassword);
		}
		SpringApplication.run(TechLabSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initAdmin(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
		return args -> {
			if (userRepo.findByUsername("admin").isEmpty()) {
				Role adminRole = roleRepo.findByName("ROLE_ADMIN")
						.orElseGet(() -> roleRepo.save(new Role(null, "ROLE_ADMIN")));

				Usuario admin = new Usuario();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("admin123"));
				admin.setRoles(List.of(adminRole));

				userRepo.save(admin);
				System.out.println("Admin creado con éxito.");
			}
		};
	}

}
