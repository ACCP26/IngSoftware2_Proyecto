package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Estudiantes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioEstudiantes extends CrudRepository<Estudiantes,Long>,JpaSpecificationExecutor<Estudiantes>{
}
