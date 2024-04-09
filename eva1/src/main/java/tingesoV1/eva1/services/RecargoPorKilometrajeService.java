package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;
import tingesoV1.eva1.repositories.RecargoPorKilometrajeRepository;

import java.util.ArrayList;

@Service
public class RecargoPorKilometrajeService {

    @Autowired
    RecargoPorKilometrajeRepository recargoPorKilometrajeRepository;

    public ArrayList<RecargoPorKilometrajeEntity> getRecargosPorKilometraje(){
        return (ArrayList<RecargoPorKilometrajeEntity>) recargoPorKilometrajeRepository.findAll();
    }

    public RecargoPorKilometrajeEntity saveRecargoPorKilometraje(RecargoPorKilometrajeEntity recargoPorKilometraje){
        return recargoPorKilometrajeRepository.save(recargoPorKilometraje);
    }


    public RecargoPorKilometrajeEntity updateRecargoPorKilometraje(RecargoPorKilometrajeEntity recargoPorKilometraje) {
        return recargoPorKilometrajeRepository.save(recargoPorKilometraje);
    }

    public boolean deleteRecargoPorKilometraje(Long id) throws Exception {
        try{
            recargoPorKilometrajeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
