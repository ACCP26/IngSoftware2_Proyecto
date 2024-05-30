package co.software.proyebase.servicios;

import co.software.proyebase.dto.NotaDto;
import co.software.proyebase.entidades.Notas;
import co.software.proyebase.exception.ResourceNotFoundException;
import co.software.proyebase.repositorios.RepositorioNotas;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioNotas implements Serializable {

    private ModelMapper modelMapper;

    private final RepositorioNotas repoNotas;

    public NotaDto registrar(NotaDto notaDto){

        Notas notas = repoNotas.save(modelMapper.map(notaDto, Notas.class));
        return modelMapper.map(notas, NotaDto.class);
    }
    public List<NotaDto> listarNotas(){
        TypeToken<List<NotaDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoNotas.findAll(),typeToken.getType());
    }

    public NotaDto obtenerNota(long serial){
        Notas notas = repoNotas.findById(serial).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(notas, NotaDto.class);
    }

    public NotaDto actualizar(NotaDto notaDto){
        repoNotas.save(modelMapper.map(notaDto,Notas.class));

        return notaDto;
    }

    public void eliminar(long serial){

        repoNotas.deleteById(serial);
    }
}
