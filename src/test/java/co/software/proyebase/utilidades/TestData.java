package co.software.proyebase.utilidades;

import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.entidades.Nota;

public class TestData {

    public static Asignatura crearAsignatura() {
        return Asignatura.builder()
                .codigo(17454)
                .nombre("Ingenieria de software")
                .periodo("2024-1")
                .build();
    }

    public static Estudiantes crearEstudiantes() {
        Estudiantes estudiantes = new Estudiantes();
        estudiantes.setNombre("Juan Perez");
        return estudiantes;
    }

    public static Nota crearNota(Estudiantes estudiantes) {
        Nota nota = new Nota();
        nota.setValor(9.5);
        nota.setRangoMinimo(0.0);
        nota.setRangoMaximo(10.0);
        nota.setEstudiantes(estudiantes);
        return nota;
    }
}



