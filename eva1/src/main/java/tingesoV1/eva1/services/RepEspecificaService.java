package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.RepEspecificaEntity;
import tingesoV1.eva1.repositories.RepEspecificaRepository;

import java.util.ArrayList;

@Service
public class RepEspecificaService {
    @Autowired
    RepEspecificaRepository repEspecificaRepository;




    public ArrayList<RepEspecificaEntity> getAllReparacionesEspecificas(){
        return (ArrayList<RepEspecificaEntity>) repEspecificaRepository.findAll();
    }

    public RepEspecificaEntity saveTipoDeRep(RepEspecificaEntity paycheck){
        return repEspecificaRepository.save(paycheck);
    }





}

