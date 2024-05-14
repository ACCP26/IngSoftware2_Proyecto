package co.software.proyebase.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor

public class ActividadDto implements Serializable{
    private long numero;
    @NotBlank(message = "El nombre de la actividad debe ser obligatorio")
    private String nombre;
    @NotBlank(message = "El corte de la actividad debe ser obligatorio")
    private long corte;
    @NotBlank(message = "El peso de la actividad debe ser obligatorio")
    private long peso;


}
