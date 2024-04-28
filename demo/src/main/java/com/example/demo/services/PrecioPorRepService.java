package com.example.demo.services;

import com.example.demo.entities.PrecioPorRepEntity;
import com.example.demo.repositories.PrecioPorRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Objects;

@Service
public class PrecioPorRepService {
    @Autowired
    PrecioPorRepRepository precioPorRepRepository;

    public ArrayList<PrecioPorRepEntity> getAllPrecios(){
        return (ArrayList<PrecioPorRepEntity>) precioPorRepRepository.findAll();
    }

    //NO TESTEADA EN CONTROLLERS
    public Integer getPrecioByTipoRepYTipoDeMotor(String tipoDeRep,String tipoDeMotor){
        Integer precio=-2;

        if (Objects.equals(tipoDeMotor, "GASOLINA")){
            precio=precioPorRepRepository.getPrecioRep_MotorGasolina(tipoDeRep);
        } else if (Objects.equals(tipoDeMotor, "DIESEL")) {
            precio=precioPorRepRepository.getPrecioRep_MotorDiesel(tipoDeRep);
        } else if (Objects.equals(tipoDeMotor, "HIBRIDO")) {
            precio=precioPorRepRepository.getPrecioRep_MotorHibrido(tipoDeRep);

        } else if (Objects.equals(tipoDeMotor, "ELECTRICO")) {
            precio=precioPorRepRepository.getPrecioRep_MotorElectrico(tipoDeRep);
        }
        return precio;

    }

    public PrecioPorRepEntity savePrecio(PrecioPorRepEntity precio){
        return precioPorRepRepository.save(precio);
    }


    public PrecioPorRepEntity updatePrecioPorRep(PrecioPorRepEntity precioPorRep) {
        return precioPorRepRepository.save(precioPorRep);
    }

    public boolean deletePrecioPorRep(Long id) throws Exception {
        try{
            precioPorRepRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
