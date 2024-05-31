package co.software.proyebase.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotaDto {
    public Double setRangoMinimo;
    // Getters and Setters
    private Long id;
    private Double valor;
    private Double rangoMinimo;
    private Double rangoMaximo;

    public Double setRangoMaximo() {
    return rangoMaximo;
    }
}
