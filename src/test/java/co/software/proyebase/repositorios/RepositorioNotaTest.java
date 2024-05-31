package co.software.proyebase.repositorios;

import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.entidades.Nota;
import co.software.proyebase.utilidades.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RepositorioNotaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private RepositorioNota repositorioNota;

    private Estudiantes estudiantes;

    @BeforeEach
    void setUp() {
        estudiantes = TestData.crearEstudiantes();
        testEntityManager.persist(estudiantes);

        Nota nota = TestData.crearNota(estudiantes);
        testEntityManager.persist(nota);
    }

    @Test
    public void crearNota() {
        Nota nota = TestData.crearNota(estudiantes);
        Nota guardar = repositorioNota.save(nota);

        Optional<Nota> comprobar = repositorioNota.findById(guardar.getId());

        assertThat(comprobar.isPresent()).isTrue();
        assertThat(comprobar.get().getValor()).isEqualTo(9.5);
    }

    @Test
    public void listarNotas() {
        List<Nota> notaList = (List<Nota>) repositorioNota.findAll();
        assertThat(notaList).isNotNull();
        assertThat(notaList.size()).isGreaterThan(0);

        Nota nota = TestData.crearNota(estudiantes);
        testEntityManager.persist(nota);

        assertThat(notaList).contains(nota);
    }

    @Test
    public void actualizarNota() {
        Nota nota = TestData.crearNota(estudiantes);
        Nota guardar = repositorioNota.save(nota);

        Optional<Nota> actualizar = repositorioNota.findById(guardar.getId());
        assertThat(actualizar.isPresent()).isTrue();

        Nota notaActualizar = actualizar.get();
        notaActualizar.setValor(8.0);
        repositorioNota.save(notaActualizar);

        Optional<Nota> actualizada = repositorioNota.findById(guardar.getId());
        assertThat(actualizada.isPresent()).isTrue();

        Nota notaActualizada = actualizada.get();
        assertThat(notaActualizada.getValor()).isEqualTo(8.0);
    }
}
