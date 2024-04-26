package com.example.demo.services;

import com.example.demo.entities.BonoAplicadoEntity;
import com.example.demo.repositories.BonoAplicadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class BonoAplicadoService {
    @Autowired
    BonoAplicadoRepository bonoAplicadoRepository;


    public ArrayList<BonoAplicadoEntity> getBonosAplicados(){
        return (ArrayList<BonoAplicadoEntity>) bonoAplicadoRepository.findAll();
    }

    public BonoAplicadoEntity saveBonoAplicado(BonoAplicadoEntity bonoAplicado){
        return bonoAplicadoRepository.save(bonoAplicado);
    }


    public BonoAplicadoEntity updateBonoAplicado(BonoAplicadoEntity bonoAplicado) {
        return bonoAplicadoRepository.save(bonoAplicado);
    }

    public boolean deleteBonoAplicado(Long id) throws Exception {
        try{
            bonoAplicadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
