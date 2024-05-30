package co.software.proyebase.controladores;

import co.software.proyebase.dto.NotaDto;
import co.software.proyebase.servicios.ServicioNotas;
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
@RequestMapping("/api/notas")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})

public class ControladorNotas {

    private ServicioNotas servicioNotas;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NotaDto>registrar(@Validated @RequestBody NotaDto entidadDto){
        entidadDto = servicioNotas.registrar(entidadDto);

        return new ResponseEntity<>(entidadDto, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<NotaDto>> listarEstudiantes(){

        return ResponseEntity.ok(servicioNotas.listarNotas());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<NotaDto> obtenerPorId(@PathVariable("serial") Long serial){
        log.info("Ingrese el numero de la nota " + serial);
        return ResponseEntity.ok(servicioNotas.obtenerNota(serial));
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NotaDto> actualizar(@Validated @RequestBody NotaDto notaDto){
        notaDto = servicioNotas.actualizar(notaDto);

        return new ResponseEntity<>(notaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("serial") Long serial){

        servicioNotas.eliminar(serial);
    }
}
