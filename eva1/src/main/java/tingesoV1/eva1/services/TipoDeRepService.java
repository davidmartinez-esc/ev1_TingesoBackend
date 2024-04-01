package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.TipoDeRepEntity;
import tingesoV1.eva1.repositories.TipoDeRepRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoDeRepService {
    @Autowired
    TipoDeRepRepository tipoDeRepRepository;




    public ArrayList<TipoDeRepEntity> getReparaciones(){
        return (ArrayList<TipoDeRepEntity>) tipoDeRepRepository.findAll();
    }

    public TipoDeRepEntity saveTipoDeRep(TipoDeRepEntity paycheck){
        return tipoDeRepRepository.save(paycheck);
    }





}

