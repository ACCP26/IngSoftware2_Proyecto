package co.software.proyebase.controladores;

import co.software.proyebase.dto.AsignaturaDto;
import co.software.proyebase.servicios.ServicioAsignatura;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}
