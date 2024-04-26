package com.example.demo.controllers;

import com.example.demo.entities.DescuentoPorNRepEntity;
import com.example.demo.services.DescuentoPorNRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/descuentosPorNRep")
@CrossOrigin("*")

public class DescuentoPorNRepController {
    @Autowired
    DescuentoPorNRepService descuentoService;

    @GetMapping("/")
    public ResponseEntity<List<DescuentoPorNRepEntity>> listDescuentoPorNReps() {
        List<DescuentoPorNRepEntity> descuento = descuentoService.getDescuentoPorNReps();
        return ResponseEntity.ok(descuento);
    }

    @PostMapping("/")
    public ResponseEntity<DescuentoPorNRepEntity> saveDescuentoPorNRep(@RequestBody DescuentoPorNRepEntity descuento) {
        DescuentoPorNRepEntity newDescuentoPorNRep = descuentoService.saveDescuentoPorNRep(descuento);
        return ResponseEntity.ok(newDescuentoPorNRep);
    }
    @PutMapping("/")
    public ResponseEntity<DescuentoPorNRepEntity> updateDescuentoPorNRep(@RequestBody DescuentoPorNRepEntity descuento){
        DescuentoPorNRepEntity descuentoUpdated = descuentoService.updateDescuentoPorNRep(descuento);
        return ResponseEntity.ok(descuentoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDescuentoPorNRepById(@PathVariable Long id) throws Exception {
        var isDeleted= descuentoService.deleteDescuentoPorNRep(id);
        return ResponseEntity.noContent().build();
    }
}
