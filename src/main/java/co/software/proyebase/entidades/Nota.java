package co.software.proyebase.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "NOTA")
public class Nota {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Double rangoMinimo;
    private Double rangoMaximo;

    public Nota() {
    }

    public void setEstudiantes(Estudiantes estudiantes) {
    }
}

