package co.software.proyebase.servicios;

import co.software.proyebase.entidades.Actividades;
import co.software.proyebase.dto.ActividadDto;
import co.software.proyebase.repositorios.RepositorioActividades;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@Service
public class ServicioActividades implements Serializable{

    private ModelMapper modelMapper;

    private final RepositorioActividades repoActividades;

    public ActividadDto registrar(ActividadDto actividadDto){

        Actividades actividad = repoActividades.save(modelMapper.map(actividadDto,Actividades.class));
        return modelMapper.map(actividad, ActividadDto.class);
    }
}
