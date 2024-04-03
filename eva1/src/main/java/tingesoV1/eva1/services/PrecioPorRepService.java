package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.PrecioPorRepEntity;
import tingesoV1.eva1.repositories.PrecioPorRepRepository;
import tingesoV1.eva1.repositories.RepEspecificaRepository;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class PrecioPorRepService {
    @Autowired
    PrecioPorRepRepository precioPorRepRepository;

    public ArrayList<PrecioPorRepEntity> getAllPrecios(){
        return (ArrayList<PrecioPorRepEntity>) precioPorRepRepository.findAll();
    }

    public Integer getPrecioByTipoRepYTipoDeMotor(String tipoDeRep,String tipoDeMotor){
        if (Objects.equals(tipoDeMotor, "Gasolina")){

        } else if (Objects.equals(tipoDeMotor, "Diesel")) {

        } else if (Objects.equals(tipoDeMotor, "Hibrido")) {

        } else if (Objects.equals(tipoDeMotor, "Electrico")) {

        }

    }

    public PrecioPorRepEntity savePrecio(PrecioPorRepEntity precio){
        return precioPorRepRepository.save(precio);
    }
}
