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
public class NotaDto implements Serializable {

    private long serial;
    @NotBlank(message = "El nombre de la actividad debe ser obligatorio")
    private long calificacion;
    private Long estudianteID;
    private Long actividadID;

}
