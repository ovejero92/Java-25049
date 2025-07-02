package com.TechLab.spring;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechLabSpringApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		String dbPassword = dotenv.get("SPRING_DATASOURCE_PASSWORD");
		if(dbPassword != null) {
			System.setProperty("SPRING_DATASOURCE_PASSWORD",dbPassword);
		} else {
			System.out.println("la clave de .env no esta ");
		}
		SpringApplication.run(TechLabSpringApplication.class, args);
	}


}