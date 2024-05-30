package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Actividades;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioActividades extends CrudRepository<Actividades,Long>, JpaSpecificationExecutor<Actividades> {
}
