package co.software.proyebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class ProyebaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyebaseApplication.class, args);
		System.out.println("Proyecto Ingenieria de Software");
	}


}
