package co.software.proyebase.config;

import co.software.proyebase.dto.AsignaturaDto;
import co.software.proyebase.dto.EstudianteDto;
import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.entidades.Estudiantes;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperconfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Estudiantes.class, EstudianteDto.class)
                .addMappings(mapper -> mapper.skip(EstudianteDto::setAsignaturaID))
                .addMappings(mapper -> mapper.skip(EstudianteDto::setActividad))
                .addMappings(mapper -> mapper.skip(EstudianteDto::setNota));

        modelMapper.typeMap(Asignatura.class, AsignaturaDto.class)
                .addMappings(mapper -> mapper.skip(AsignaturaDto::setEstudianteID))
                .addMappings(mapper -> mapper.skip(AsignaturaDto::setActividadID));
        return modelMapper;
    }
}
