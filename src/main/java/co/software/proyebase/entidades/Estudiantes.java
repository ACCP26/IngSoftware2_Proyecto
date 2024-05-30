package co.software.proyebase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Estudiantes")
@Table(name = "ESTUDIANTES")
public class Estudiantes{

    @Id
    @Column(name = "EST_ID",nullable = false)
    private long identificacion;

    @Column(name = "EST_NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "EST_APELLIDO",nullable = false)
    private String apellido;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "estudiantes_actividades",joinColumns = @JoinColumn(name = "est_id",referencedColumnName = "EST_ID"),
            inverseJoinColumns = @JoinColumn(name = "act_numero",referencedColumnName = "ACT_SERIAL")
    )
    private Actividades actividad;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "estudiante",cascade = CascadeType.ALL)
    @JoinColumn(name = "NOT_SERIAL")
    private Notas nota;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "estudiante_asignatura",joinColumns = @JoinColumn(name = "est_id",referencedColumnName = "EST_ID"),
            inverseJoinColumns = @JoinColumn(name = "asi_codigo",referencedColumnName = "ASI_CODIGO")
    )
    List<Asignatura> asignatura;

}
