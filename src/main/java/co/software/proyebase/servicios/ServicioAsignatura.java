package co.software.proyebase.servicios;

import co.software.proyebase.dto.AsignaturaDto;
import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.repositorios.RepositorioAsignaturas;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ServicioAsignatura {

    private ModelMapper modelMapper;

    private final RepositorioAsignaturas repoAsignaturas;

    public AsignaturaDto registrar(AsignaturaDto asignaturaDto){

        Asignatura asignatura = repoAsignaturas.save(modelMapper.map(asignaturaDto,Asignatura.class));
        return modelMapper.map(asignatura,AsignaturaDto.class);
    }
}
