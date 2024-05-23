package co.software.proyebase.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("unused")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Asignatura")
@Table(name = "signature")
public class Asignatura implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ASIGNATURA")
    @SequenceGenerator(name = "SEQ_ASIGNATURA",sequenceName = "SEQ_ASIGNATURA",allocationSize = 1)
    @Column(name = "ASI_SERIAL",nullable = false)
    private long serial;

    @Column(name = "ASI_COD",nullable = false)
    private long codigo;

    @Column(name = "ASI_NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "ASI_CORTE",nullable = false)
    private long corte;
}