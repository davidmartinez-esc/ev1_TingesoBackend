package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.DescuentoAplicadoEntity;
import tingesoV1.eva1.entities.RecargoAplicadoEntity;
import tingesoV1.eva1.repositories.DescuentoAplicadoRepository;
import tingesoV1.eva1.repositories.RecargoAplicadoRepository;

import java.util.ArrayList;

@Service
public class AplicadosAPrecioService {
    @Autowired
    DescuentoAplicadoRepository descuentoAplicadoRepository;

    @Autowired
    RecargoAplicadoRepository recargoAplicadoRepository;

    public ArrayList<DescuentoAplicadoEntity> getDescuentosAplicados(){
        return (ArrayList<DescuentoAplicadoEntity>) descuentoAplicadoRepository.findAll();
    }

    public DescuentoAplicadoEntity saveDescuentoAplicado(DescuentoAplicadoEntity descuentoAplicado){
        return descuentoAplicadoRepository.save(descuentoAplicado);
    }


    public DescuentoAplicadoEntity updateDescuentoAplicado(DescuentoAplicadoEntity descuentoAplicado) {
        return descuentoAplicadoRepository.save(descuentoAplicado);
    }

    public boolean deleteDescuentoAplicado(Long id) throws Exception {
        try{
            descuentoAplicadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    //RECARGO APLICADO--------------------------------------------------------------------






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
