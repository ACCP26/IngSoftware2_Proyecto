package co.software.proyebase.servicios;

import co.software.proyebase.repositorios.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import co.software.proyebase.dto.NotaDto;
import co.software.proyebase.entidades.Nota;

@Service
public class ServicioNota {

    private final RepositorioNota repositorioNota;

    @Autowired
    public ServicioNota(RepositorioNota repositorioNota){
        this.repositorioNota = repositorioNota;
    }

    public Nota guardarNota(NotaDto notaDto) {
        if (notaDto.getValor() == null) {
            throw new IllegalArgumentException("El campo Nota no debe estar vacío.");
        }
        if (notaDto.getValor() < notaDto.getRangoMinimo() || notaDto.getValor() > notaDto.getRangoMaximo()) {
            throw new IllegalArgumentException("La nota debe estar dentro del rango asignado de la actividad.");
        }

        Nota nota = new Nota();
        nota.setValor(notaDto.getValor());
        nota.setRangoMinimo(notaDto.getRangoMinimo());
        nota.setRangoMaximo(notaDto.getRangoMaximo());

        return repositorioNota.save(nota);
    }

    public Optional<Nota> obtenerNota(Long id) {
        return repositorioNota.findById(id);
    }
}

