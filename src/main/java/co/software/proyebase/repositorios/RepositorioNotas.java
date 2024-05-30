package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Notas;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
public interface RepositorioNotas extends CrudRepository<Notas,Long>,JpaSpecificationExecutor<Notas> {
}
