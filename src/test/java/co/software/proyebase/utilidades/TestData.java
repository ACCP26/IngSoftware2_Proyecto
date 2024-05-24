package co.software.proyebase.utilidades;

import co.software.proyebase.entidades.Asignatura;

public class TestData {

    public static Asignatura crearAsignatura(){
        return Asignatura.builder()
                .codigo(17454)
                .nombre("Ingenieria de software")
                .periodo("2024-1")
                .build();
    }
}
