package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.utilidades.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RepositorioAsignaturasTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private RepositorioAsignaturas repositorioAsignaturas;
    @BeforeEach
    void setUp() {
        Asignatura asignatura = TestData.crearAsignatura();
        testEntityManager.persist(asignatura);
    }

    @Test
    public void crearSolicitud(){
        Asignatura asignatura = TestData.crearAsignatura();
        Asignatura guardar = repositorioAsignaturas.save(asignatura);

        Optional<Asignatura> comprobar = repositorioAsignaturas.findById(guardar.getCodigo());

        assertThat(comprobar.isPresent()).isTrue();
        assertThat(comprobar.get().getNombre()).isEqualTo("Ingenieria de software");
    }

    @Test
    public void listarSolicitud(){

        Asignatura asignatura = TestData.crearAsignatura();

        List<Asignatura> asignaturaList = (List<Asignatura>) repositorioAsignaturas.findAll();
        assertThat(asignaturaList).isNotNull();
        assertThat(asignaturaList.size()).isGreaterThan(0);
        assertThat(asignaturaList).contains(asignatura);
    }

    @Test
    public void actualizarSolicitud(){

        Asignatura asignatura = TestData.crearAsignatura();
        Asignatura guardar = repositorioAsignaturas.save(asignatura);

        Optional<Asignatura> actualizar = repositorioAsignaturas.findById(guardar.getCodigo());
        assertThat(actualizar.isPresent()).isTrue();

        Asignatura asignaturaActualizar = actualizar.get();
        asignaturaActualizar.setNombre("Analisis de algoritmos");
        asignaturaActualizar.setPeriodo("2023-2");
        repositorioAsignaturas.save(asignaturaActualizar);

        Optional<Asignatura> actualizada = repositorioAsignaturas.findById(guardar.getCodigo());
        assertThat(actualizada.isPresent()).isTrue();

        Asignatura asignatura1 = actualizada.get();
        assertThat(asignatura1.getNombre()).isEqualTo("Analisis de algoritmos");
        assertThat(asignatura1.getPeriodo()).isEqualTo("2023-2");
    }
}