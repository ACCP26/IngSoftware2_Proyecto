package co.software.proyebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.repositorios.RepositorioEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
public class ProyebaseApplication{

	public static void main(String[] args) {

		SpringApplication.run(ProyebaseApplication.class, args);
		System.out.println("Proyecto software");
	}
/*
	@Autowired
	RepositorioEstudiantes repoEstudiante;
	@Override
	public void run(String... args) throws Exception{


		Estudiantes e = new Estudiantes();
		e.setNombre("Andres");
		e.setApellido("Corchuelo");
		e.setIdentificacion(1014736717);

		repoEstudiante.save(e);

		List<Estudiantes> listEstu = (List<Estudiantes>) repoEstudiante.findAll();
		for(Estudiantes estudiantes : listEstu){
			System.out.println(estudiantes);
		}
	}

*/
}
