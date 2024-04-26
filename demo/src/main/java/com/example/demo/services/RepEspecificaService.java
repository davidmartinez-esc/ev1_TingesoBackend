package com.example.demo.services;

import com.example.demo.entities.RepEspecificaEntity;
import com.example.demo.repositories.RepEspecificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class RepEspecificaService {
    @Autowired
    RepEspecificaRepository repEspecificaRepository;




    public ArrayList<RepEspecificaEntity> getAllReparacionesEspecificas(){
        return (ArrayList<RepEspecificaEntity>) repEspecificaRepository.findAll();
    }

    public RepEspecificaEntity saveTipoDeRep(RepEspecificaEntity reparacion){
        return repEspecificaRepository.save(reparacion);
    }


    public RepEspecificaEntity updateRepEspecifica(RepEspecificaEntity repEspecifica) {
        return repEspecificaRepository.save(repEspecifica);
    }

    public boolean deleteRepEspecifica(Long id) throws Exception {
        try{
            repEspecificaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }





}

