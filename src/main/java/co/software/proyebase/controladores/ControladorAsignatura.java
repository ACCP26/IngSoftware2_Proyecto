package co.software.proyebase.controladores;

import co.software.proyebase.dto.AsignaturaDto;
import co.software.proyebase.entidades.Asignatura;
import co.software.proyebase.servicios.ServicioAsignatura;
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
@RequestMapping("api/asignaturas")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})

public class ControladorAsignatura {

    private ServicioAsignatura servicioAsignatura;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AsignaturaDto>registrar(@Validated @RequestBody AsignaturaDto asignaturaDto){
        asignaturaDto = servicioAsignatura.registrar(asignaturaDto);

        return new ResponseEntity<>(asignaturaDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<AsignaturaDto>> listarAsignaturas(){

        return ResponseEntity.ok(servicioAsignatura.listarAsignaturas());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<AsignaturaDto> obtenerPorId(@PathVariable("codigo") Long codigo){
        log.info("Ingresa el codigo de la asignatura " + codigo);
        return ResponseEntity.ok(servicioAsignatura.obtenerAsignatura(codigo));
    }
    @GetMapping("/estudiantes")
    public ResponseEntity<List<Asignatura>> obtenerEstudiantes(@PathVariable("codigo")Long codigo){
        log.info("Ingresa el codigo de la asignatura" + codigo);
        return ResponseEntity.ok(servicioAsignatura.obtenerEstudiantes(codigo));
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AsignaturaDto> actualizar(@Validated @RequestBody AsignaturaDto asignaturaDto){
        asignaturaDto = servicioAsignatura.actualizar(asignaturaDto);

        return new ResponseEntity<>(asignaturaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("codigo") Long codigo){

        servicioAsignatura.eliminar(codigo);
    }
}
