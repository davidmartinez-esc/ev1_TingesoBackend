package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.IngresoARepEntity;

import tingesoV1.eva1.repositories.IngresoARepRepository;

import java.util.ArrayList;

@Service
public class IngresoARepService {
    @Autowired
    IngresoARepRepository ingresoARepRepository;

    public ArrayList<IngresoARepEntity> getReparaciones(){
        return (ArrayList<IngresoARepEntity>) ingresoARepRepository.findAll();
    }

    public IngresoARepEntity saveReparacion(IngresoARepEntity reparacion){
        return ingresoARepRepository.save(reparacion);
    }
}
