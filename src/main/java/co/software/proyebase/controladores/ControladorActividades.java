package co.software.proyebase.controladores;

import co.software.proyebase.dto.ActividadDto;
import co.software.proyebase.servicios.ServicioActividades;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
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

    @GetMapping("/")
    public ResponseEntity<List<ActividadDto>> listarActividades(){

        return ResponseEntity.ok(servicioActividad.listarActividades());
    }

    @GetMapping("/{numero}")
    public ResponseEntity<ActividadDto> obtenerPorId(@PathVariable("numero") Long numero){
        log.info("Ingresa numero de actividad " + numero);
        return ResponseEntity.ok(servicioActividad.obtenerActividad(numero));
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ActividadDto> actualizar(@Validated @RequestBody ActividadDto actividadDto){
        actividadDto = servicioActividad.actualizar(actividadDto);

        return new ResponseEntity<>(actividadDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{numero}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("numero") Long numero){

        servicioActividad.eliminar(numero);
    }
}
