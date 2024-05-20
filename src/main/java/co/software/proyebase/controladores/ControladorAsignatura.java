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
@RequestMapping
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET,RequestMethod.DELETE,})

public class ControladorAsignatura {

    private ServicioAsignatura servicioAsignatura;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AsignaturaDto>registrar(Validated AsignaturaDto, AsignaturaDto entidadDto){
        entidadDto = servicioAsignatura.registrar(entidadDto);

        return new ResponseEntity<>(entidadDto,HttpStatus.CREATED);
    }
}
