package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.repositories.RecargoPorAntiguedadRepository;

import java.util.ArrayList;

@Service

public class RecargoPorAntiguedadService {

    @Autowired
    RecargoPorAntiguedadRepository recargoPorAntiguedadRepository;

    public ArrayList<RecargoPorAntiguedadEntity> getRecargosPorAntiguedad(){
        return (ArrayList<RecargoPorAntiguedadEntity>) recargoPorAntiguedadRepository.findAll();
    }

    public RecargoPorAntiguedadEntity saveRecargoPorAntiguedad(RecargoPorAntiguedadEntity recargoPorAntiguedad){
        return recargoPorAntiguedadRepository.save(recargoPorAntiguedad);
    }


    public RecargoPorAntiguedadEntity updateRecargoPorAntiguedad(RecargoPorAntiguedadEntity recargoPorAntiguedad) {
        return recargoPorAntiguedadRepository.save(recargoPorAntiguedad);
    }

    public boolean deleteRecargoPorAntiguedad(Long id) throws Exception {
        try{
            recargoPorAntiguedadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
