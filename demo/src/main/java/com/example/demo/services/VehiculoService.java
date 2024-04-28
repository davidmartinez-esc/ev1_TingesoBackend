package com.example.demo.services;

import com.example.demo.entities.VehiculoEntity;
import com.example.demo.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    //TESTEAR
    public VehiculoEntity getVehiculoById(Long id){
        return vehiculoRepository.findById(id).get();
    }

    public boolean deleteVehiculo(Long id) throws Exception {
        try{
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("No se pudo borrar el vehiculo");
        }


    }

}
