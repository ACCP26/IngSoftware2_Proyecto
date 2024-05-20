package co.software.proyebase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
@ToString
@AllArgsConstructor
@Data
@NoArgsConstructor

public class AsignaturaDto implements Serializable{
    private long Serial;
    @NotBlank(message = "El campo codigo no debe estar vacio")
    private long codigo;
    @NotBlank(message = "El nombre de la asignatura no debe estar vacio")
    private String nombre;
    @NotBlank(message = "El campo corte no debe estar vacio")
    private long corte;
}
