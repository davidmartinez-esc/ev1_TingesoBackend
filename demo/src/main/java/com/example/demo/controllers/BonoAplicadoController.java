package com.example.demo.controllers;

import com.example.demo.entities.BonoAplicadoEntity;
import com.example.demo.services.BonoAplicadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/bonoAplicado")
@CrossOrigin("*")
public class BonoAplicadoController {
    @Autowired
    BonoAplicadoService bonoAplicadoService;

    @GetMapping("/")
    public ResponseEntity<List<BonoAplicadoEntity>> listBonosAplicados() {
        List<BonoAplicadoEntity> bonoAplicado = bonoAplicadoService.getBonosAplicados();
        return ResponseEntity.ok(bonoAplicado);
    }

    @PostMapping("/")
    public ResponseEntity<BonoAplicadoEntity> saveBonoAplicado(@RequestBody BonoAplicadoEntity bonoAplicado) {
        BonoAplicadoEntity newBonoAplicado = bonoAplicadoService.saveBonoAplicado(bonoAplicado);
        return ResponseEntity.ok(newBonoAplicado);
    }
    @PutMapping("/")
    public ResponseEntity<BonoAplicadoEntity> updateBonoAplicado(@RequestBody BonoAplicadoEntity bonoAplicado){
        BonoAplicadoEntity bonoAplicadoUpdated = bonoAplicadoService.updateBonoAplicado(bonoAplicado);
        return ResponseEntity.ok(bonoAplicadoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBonoAplicadoById(@PathVariable Long id) throws Exception {
        var isDeleted= bonoAplicadoService.deleteBonoAplicado(id);
        return ResponseEntity.noContent().build();
    }
}
