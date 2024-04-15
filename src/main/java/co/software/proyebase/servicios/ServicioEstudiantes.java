package co.software.proyebase.servicios;

import co.software.proyebase.dto.EstudianteDto;
import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.repositorios.RepositorioEstudiantes;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import java.io.Serializable;
@AllArgsConstructor
@Service
public class ServicioEstudiantes implements Serializable{

    private ModelMapper modelMapper;
    private final RepositorioEstudiantes repoEstudiantes;

    public EstudianteDto registrar(EstudianteDto estudianteDto){

        Estudiantes estudiante = repoEstudiantes.save(modelMapper.map(estudianteDto, Estudiantes.class));
        return modelMapper.map(estudiante, EstudianteDto.class);
    }
}
