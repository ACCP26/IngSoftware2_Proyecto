package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioNota extends JpaRepository<Nota, Long> {

    List<Nota> findByValorBetween(Double minValor, Double maxValor);
    @Query("SELECT n FROM Nota n WHERE n.estudiante.id = :estudianteId")
    List<Nota> findByEstudianteId(@Param("estudianteId") Long estudianteId);
}
