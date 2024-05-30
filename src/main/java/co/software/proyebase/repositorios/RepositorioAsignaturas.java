package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.entidades.Estudiantes;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioAsignaturas extends CrudRepository<Asignatura, Long>, JpaSpecificationExecutor<Asignatura> {
    @Query("SELECT e.estudiantes FROM Asignaturas e where e.codigo = :codigo ")
    List<Estudiantes> findEstudiantesByAsignaturaCodigo(@Param("codigo") Long codigo);
}
