package com.example.demo.services;

import com.example.demo.entities.DescuentoPorNRepEntity;
import com.example.demo.repositories.DescuentoPorNRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
