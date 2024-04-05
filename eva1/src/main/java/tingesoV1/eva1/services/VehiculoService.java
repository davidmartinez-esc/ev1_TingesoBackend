package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.VehiculoEntity;

import tingesoV1.eva1.repositories.VehiculoRepository;

import java.util.ArrayList;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public ArrayList<VehiculoEntity> getVehiculos(){
        return (ArrayList<VehiculoEntity>) vehiculoRepository.findAll();
    }

    public VehiculoEntity saveVehiculo(VehiculoEntity vehiculo){
        return vehiculoRepository.save(vehiculo);
    }


    public VehiculoEntity updateVehiculo(VehiculoEntity vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public boolean deleteVehiculo(Long id) throws Exception {
        try{
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
