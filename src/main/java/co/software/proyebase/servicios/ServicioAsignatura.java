package co.software.proyebase.servicios;

import co.software.proyebase.dto.AsignaturaDto;
import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.repositorios.RepositorioAsignatura;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;


import java.io.Serializable;

@AllArgsConstructor
@Service

public class ServicioAsignatura implements Serializable {

    private ModelMapper modelMapper;

    private final RepositorioAsignatura repositorioAsignatura;
    @Qualifier("compositeMeterRegistry")
    private Object AsignaturaDto;

    public AsignaturaDto registrar(AsignaturaDto entidadDto) {
        Asignatura asignatura = repositorioAsignatura.save(modelMapper.map(AsignaturaDto, Asignatura.class));
        return modelMapper.map(asignatura, AsignaturaDto.class);
    }
}
