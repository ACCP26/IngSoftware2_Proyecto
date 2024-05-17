package co.software.proyebase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Estudiantes")
@Table(name = "ESTUDIANTES")
public class Estudiantes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ESTUDIANTES")
    @SequenceGenerator(name = "SEQ_ESTUDIANTES",sequenceName = "SEQ_ESTUDIANTES",allocationSize = 1)
    @Column(name = "EST_SERIAL",nullable = false)
    private long serial;

    @Column(name = "EST_ID",nullable = false)
    private long identificacion;

    @Column(name = "EST_NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "EST_APELLIDO",nullable = false)
    private String apellido;
}
