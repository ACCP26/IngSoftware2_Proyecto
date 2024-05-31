package co.software.proyebase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Asignaturas")
@Table(name = "ASIGNATURAS")
@Builder
public class Asignatura {

    @Id
    @Column(name = "ASI_CODIGO",nullable = false)
    private long codigo;

    @Column(name = "ASI_NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "ASI_PERIODO",nullable = false)
    private String periodo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<Estudiantes> estudiantes;

    @ManyToMany(mappedBy = "asignatura")
    List<Actividades> actividades;
}
