package co.software.proyebase.controladores;

import co.software.proyebase.dto.NotaDto;
import co.software.proyebase.entidades.Nota;
import co.software.proyebase.servicios.ServicioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class ControladorNota {

    private final ServicioNota servicioNota;

    @Autowired
    public ControladorNota(ServicioNota servicioNota) {
        this.servicioNota = servicioNota;
    }

    @PostMapping
    public ResponseEntity<Nota> agregarNota(@RequestBody NotaDto notaDto) {
        try {
            Nota nota = servicioNota.guardarNota(notaDto);
            return new ResponseEntity<>(nota, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerNota(@PathVariable Long id) {
        Optional<Nota> nota = servicioNota.obtenerNota(id);
        return nota.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
