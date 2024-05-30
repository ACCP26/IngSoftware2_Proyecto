package co.software.proyebase.controladores;

import co.software.proyebase.dto.EstudianteDto;
import co.software.proyebase.servicios.ServicioEstudiantes;
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
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})

public class ControladorEstudiantes {

    private ServicioEstudiantes servicioEstudiante;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstudianteDto>registrar(@Validated @RequestBody EstudianteDto entidadDto){
        entidadDto = servicioEstudiante.registrar(entidadDto);

        return new ResponseEntity<>(entidadDto, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<EstudianteDto>> listarEstudiantes(){

        return ResponseEntity.ok(servicioEstudiante.listarEstudiantes());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<EstudianteDto> obtenerPorId(@PathVariable("serial") Long serial){
        log.info("Ingrese el numero del estudiante " + serial);
        return ResponseEntity.ok(servicioEstudiante.obtenerEstudiante(serial));
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstudianteDto> actualizar(@Validated @RequestBody EstudianteDto estudianteDto){
        estudianteDto = servicioEstudiante.actualizar(estudianteDto);

        return new ResponseEntity<>(estudianteDto, HttpStatus.CREATED);
    }

    @GetMapping("/codigoAsignatura/{codigo}")
    public ResponseEntity<List<EstudianteDto>> obtenerEstudiantesPorAsignatura(@PathVariable("codigo") Long codigo) {
        List<EstudianteDto> estudiantes = servicioEstudiante.obtenerEstudiantesPorAsignatura(codigo);
        return ResponseEntity.ok(estudiantes);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("serial") Long serial){

        servicioEstudiante.eliminar(serial);
    }
}
