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

    @ManyToMany(mappedBy = "asignatura")
    List<Estudiantes> estudiantes;

    @ManyToOne(fetch =FetchType.EAGER )
    @JoinColumn(name = "ACT_NUMERO")
    private Actividades actividad;
}
