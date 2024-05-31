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
@Entity(name = "Actividades")
@Table(name = "ACTIVIDADES")

public class Actividades implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVIDADES")
    @SequenceGenerator(name = "SEQ_ACTIVIDADES",sequenceName = "SEQ_ACTIVIDADES", allocationSize = 1)
    @Column(name = "ACT_SERIAL",nullable = false)
    private long numero;

    @Column(name = "ACT_NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "ACT_CORTE",nullable = false)
    private long corte;

    @Column(name = "ACT_PESO",nullable = false)
    private long peso;

    @Column(name = "ACT_NOTA",nullable = false)
    private long nota;
    @Column(name = "ACT_DESCRIPCION",nullable = false)
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "actividad_asignatura", joinColumns = @JoinColumn(name = "act_numero",referencedColumnName = "ACT_SERIAL"),
            inverseJoinColumns = @JoinColumn(name = "asi_codigo",referencedColumnName = "ASI_CODIGO")
    )
    List<Asignatura> asignatura;
}
