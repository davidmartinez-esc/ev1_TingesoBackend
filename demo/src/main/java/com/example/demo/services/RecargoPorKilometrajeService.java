package com.example.demo.services;

import com.example.demo.entities.RecargoPorKilometrajeEntity;
import com.example.demo.entities.VehiculoEntity;
import com.example.demo.repositories.RecargoPorKilometrajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    private String getKilometrajeInString(int kilometraje){
        if (kilometraje>=0 && kilometraje<=5000 ){
            return "0-5.000";
        } else if (kilometraje >= 5001 && kilometraje <= 12000) {
            return "5.001-12.000";
        } else if (kilometraje >= 12001 && kilometraje <= 25000) {
            return "12.001-25.000";
        } else if (kilometraje >= 25001 && kilometraje <= 40000) {
            return "25.001-40.000";
        }else {
            return "40.000–MAS";
        }
    }

    public Integer getRecargoPorAntiguedadByTipoDeVehiculo(int kilometraje, VehiculoEntity vehiculo){
        String kilmetrajeString= getKilometrajeInString(kilometraje);

        return recargoPorKilometrajeRepository.getRecargoByKilmetrajeYTipoDeVehiculo(kilmetrajeString,vehiculo.getTipo());

    }

}
