package co.software.proyebase.servicios;

import co.software.proyebase.dto.ActividadDto;
import co.software.proyebase.dto.EstudianteDto;
import co.software.proyebase.entidades.Actividades;
import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.exception.ResourceNotFoundException;
import co.software.proyebase.repositorios.RepositorioAsignaturas;
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
    private final RepositorioAsignaturas repoAsignaturas;
    public EstudianteDto registrar(EstudianteDto estudianteDto){

        Estudiantes estudiantes = repoEstudiantes.save(modelMapper.map(estudianteDto,Estudiantes.class));
        return modelMapper.map(estudiantes, EstudianteDto.class);
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

        public List<EstudianteDto> obtenerEstudiantesPorAsignatura(Long codigo) {
            List<Estudiantes> estudiantes = repoAsignaturas.findEstudiantesByAsignaturaCodigo(codigo);
            TypeToken<List<EstudianteDto>> typeToken = new TypeToken<>() {};
            return modelMapper.map(estudiantes, typeToken.getType());
        }

    public void eliminar(long serial){

        repoEstudiantes.deleteById(serial);
    }
}
