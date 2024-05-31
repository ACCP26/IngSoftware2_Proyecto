package co.software.proyebase.servicios;

import co.software.proyebase.dto.EstudianteDto;
import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.exception.ResourceNotFoundException;
import co.software.proyebase.repositorios.RepositorioEstudiantes;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioEstudiantes implements Serializable{


    private ModelMapper modelMapper;

    private final RepositorioEstudiantes repoEstudiantes;

    public EstudianteDto registrar(EstudianteDto estudianteDto){

        Estudiantes estudiante = repoEstudiantes.save(modelMapper.map(estudianteDto, Estudiantes.class));
        return modelMapper.map(estudiante, EstudianteDto.class);
    }
    public List<EstudianteDto> listarEstudiantes(){
        TypeToken<List<EstudianteDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoEstudiantes.findAll(),typeToken.getType());
    }

    public EstudianteDto obtenerEstudiante(long serial){
        Estudiantes estudiante = repoEstudiantes.findById(serial).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(estudiante, EstudianteDto.class);
    }

    public EstudianteDto actualizar(EstudianteDto estudianteDto){
        repoEstudiantes.save(modelMapper.map(estudianteDto,Estudiantes.class));

        return estudianteDto;
    }

    public void eliminar(long serial){

        repoEstudiantes.deleteById(serial);
    }
}
