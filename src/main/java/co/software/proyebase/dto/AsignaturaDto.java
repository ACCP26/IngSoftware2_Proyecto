package co.software.proyebase.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AsignaturaDto {

    @NotBlank(message = "El codigo de la asignatura no debe estar vacio")
    private long codigo;
    @NotBlank(message = "El nombre de la asignatura no debe estar vacio")
    private String nombre;
    @NotBlank(message = "El periodo de la asignatura no debe estar vacio")
    private String periodo;
}
