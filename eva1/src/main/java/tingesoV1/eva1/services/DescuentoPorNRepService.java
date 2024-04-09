package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.DescuentoPorNRepEntity;
import tingesoV1.eva1.repositories.DescuentoPorNRepRepository;

import java.util.ArrayList;

@Service
public class DescuentoPorNRepService {
    @Autowired
    DescuentoPorNRepRepository descuentoRepository;

    public ArrayList<DescuentoPorNRepEntity> getDescuentoPorNReps(){
        return (ArrayList<DescuentoPorNRepEntity>) descuentoRepository.findAll();
    }

    public DescuentoPorNRepEntity saveDescuentoPorNRep(DescuentoPorNRepEntity descuento){
        return descuentoRepository.save(descuento);
    }


    public DescuentoPorNRepEntity updateDescuentoPorNRep(DescuentoPorNRepEntity descuento) {
        return descuentoRepository.save(descuento);
    }

    public boolean deleteDescuentoPorNRep(Long id) throws Exception {
        try{
            descuentoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
