package co.software.proyebase.servicios;

import co.software.proyebase.entidades.Actividades;
import co.software.proyebase.dto.ActividadDto;
import co.software.proyebase.exception.ResourceNotFoundException;
import co.software.proyebase.repositorios.RepositorioActividades;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioActividades implements Serializable{

    private ModelMapper modelMapper;

    private final RepositorioActividades repoActividades;

    public ActividadDto registrar(ActividadDto actividadDto){

        Actividades actividad = repoActividades.save(modelMapper.map(actividadDto,Actividades.class));
        return modelMapper.map(actividad, ActividadDto.class);
    }

    public List<ActividadDto> listarActividades(){
        TypeToken<List<ActividadDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoActividades.findAll(),typeToken.getType());
    }

    public ActividadDto obtenerActividad(long numero){
        Actividades actividad = repoActividades.findById(numero).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(actividad, ActividadDto.class);
    }

    public ActividadDto actualizar(ActividadDto actividadDto){
        repoActividades.save(modelMapper.map(actividadDto,Actividades.class));

        return actividadDto;
    }

    public void eliminar(long numero){

        repoActividades.deleteById(numero);
    }
}
