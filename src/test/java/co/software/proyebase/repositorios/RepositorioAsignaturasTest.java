package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.utilidades.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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
}