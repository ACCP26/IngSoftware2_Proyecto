package co.software.proyebase.controladores;

import co.software.proyebase.entidades.Estudiantes;
import co.software.proyebase.dto.EstudianteDto;
import co.software.proyebase.servicios.ServicioEstudiantes;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@AllArgsConstructor
@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins)",
        methods = {RequestMethod.POST})

public class ControladorEstudiantes {

    private ServicioEstudiantes servicioEstudiante;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstudianteDto> registrar(@Validated @RequestBody EstudianteDto entidadDto){
        entidadDto = servicioEstudiante.registrar(entidadDto);

        return new ResponseEntity<>(entidadDto, HttpStatus.CREATED);
    }
}
