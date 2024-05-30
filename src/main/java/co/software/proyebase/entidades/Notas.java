package co.software.proyebase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Notas")
@Table(name = "NOTAS")
public class Notas implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_NOTAS")
    @SequenceGenerator(name = "SEQ_NOTAS",sequenceName = "SEQ_NOTAS",allocationSize = 1)
    @Column(name = "NOT_SERIAL",nullable = false)
    private long serial;

    @Column(name = "NOT_CALIFICACION",nullable = false)
    private long calificacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EST_ID")
    private Estudiantes estudiante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACT_SERIAL")
    private Actividades actividad;

}
