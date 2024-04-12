package co.software.proyebase.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("unused")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Docente")
@Table(name = "Docente")
public class Docente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_DOCENTE")
    @SequenceGenerator(name = "SEQ_DOCENTE",sequenceName = "SEQ_DOCENTE",allocationSize = 1)
    @Column(name = "DOC_SERIAL",nullable = false)
    private long serial;

    @Column(name = "DOC_COD",nullable = false)
    private long codigo;

    @Column(name = "DOC_NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "DOC_PERIODO",nullable = false)
    private long periodo;
}