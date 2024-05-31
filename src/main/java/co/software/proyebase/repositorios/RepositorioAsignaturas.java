package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Asignatura;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioAsignaturas extends CrudRepository<Asignatura, Long>, JpaSpecificationExecutor<Asignatura> {
    @Query("SELECT e FROM Asignaturas e JOIN FETCH e.estudiantes where e.codigo = :codigo ")
    List<Asignatura> findAsignaturaAndAsignaturaEstudiantesById(@Param("codigo") Long codigo);
}
