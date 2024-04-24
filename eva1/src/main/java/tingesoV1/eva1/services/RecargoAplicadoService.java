package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.RecargoAplicadoEntity;
import tingesoV1.eva1.repositories.RecargoAplicadoRepository;

import java.util.ArrayList;

@Service
public class RecargoAplicadoService {

    @Autowired
    RecargoAplicadoRepository recargoAplicadoRepository;

    public ArrayList<RecargoAplicadoEntity> getRecargosAplicados(){
        return (ArrayList<RecargoAplicadoEntity>) recargoAplicadoRepository.findAll();
    }

    public RecargoAplicadoEntity saveRecargoAplicado(RecargoAplicadoEntity recargoAplicado){
        return recargoAplicadoRepository.save(recargoAplicado);
    }


    public RecargoAplicadoEntity updateRecargoAplicado(RecargoAplicadoEntity recargoAplicado) {
        return recargoAplicadoRepository.save(recargoAplicado);
    }

    public boolean deleteRecargoAplicado(Long id) throws Exception {
        try{
            recargoAplicadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
