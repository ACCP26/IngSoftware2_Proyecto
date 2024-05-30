package co.software.proyebase.servicios;

import co.software.proyebase.dto.AsignaturaDto;
import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.exception.ResourceNotFoundException;
import co.software.proyebase.repositorios.RepositorioAsignaturas;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import java.util.List;
@AllArgsConstructor
@Service
public class ServicioAsignatura {

    private ModelMapper modelMapper;

    private final RepositorioAsignaturas repoAsignaturas;

    public AsignaturaDto registrar(AsignaturaDto asignaturaDto){

        Asignatura asignatura = repoAsignaturas.save(modelMapper.map(asignaturaDto,Asignatura.class));
        return modelMapper.map(asignatura,AsignaturaDto.class);
    }

    public List<AsignaturaDto> listarAsignaturas(){
        TypeToken<List<AsignaturaDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoAsignaturas.findAll(),typeToken.getType());
    }

    public AsignaturaDto obtenerAsignatura(long codigo){
        Asignatura asignatura = repoAsignaturas.findById(codigo).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(asignatura, AsignaturaDto.class);
    }

    public List<Estudiantes> obtenerEstudiantes(Long codigo){
        TypeToken<List<Estudiantes>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoAsignaturas.findEstudiantesByAsignaturaCodigo(codigo), typeToken.getType());
    }
    public AsignaturaDto actualizar(AsignaturaDto asignaturaDto){
        repoAsignaturas.save(modelMapper.map(asignaturaDto,Asignatura.class));

        return asignaturaDto;
    }

    public void eliminar(long codigo){

        repoAsignaturas.deleteById(codigo);
    }
}
