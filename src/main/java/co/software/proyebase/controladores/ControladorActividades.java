package co.software.proyebase.controladores;

import co.software.proyebase.dto.ActividadDto;
import co.software.proyebase.servicios.ServicioActividades;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/actividades")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})

public class ControladorActividades {

    private ServicioActividades servicioActividad;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ActividadDto>registrar(@Validated @RequestBody ActividadDto actividadDto){
        actividadDto = servicioActividad.registrar(actividadDto);

        return new ResponseEntity<>(actividadDto,HttpStatus.CREATED);
    }
}
