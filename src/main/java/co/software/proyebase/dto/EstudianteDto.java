package co.software.proyebase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EstudianteDto implements Serializable {
    private long Serial;
    @NotBlank(message = "El nombre del estudiante es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido del estudiante es obligatorio")
    private String apellido;
    @NotNull(message = "La identificacion del estudiante es obligatoria")
    private long identificacion;
    private Long actividad;
    private Long nota;
    private Long asignaturaID;

}
