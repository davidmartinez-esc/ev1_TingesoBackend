package com.example.demo.controllers;

import com.example.demo.entities.PrecioPorRepEntity;
import com.example.demo.services.PrecioPorRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/precioPorRep")
@CrossOrigin("*")
public class PrecioPorRepController {
    @Autowired
    PrecioPorRepService precioPorRepService;

    @GetMapping("/")
    public ResponseEntity<List<PrecioPorRepEntity>> listPrecioPorReps() {
        List<PrecioPorRepEntity> precio = precioPorRepService.getAllPrecios();
        return ResponseEntity.ok(precio);
    }

    @PostMapping("/")
    public ResponseEntity<PrecioPorRepEntity> savePrecioPorRep(@RequestBody PrecioPorRepEntity precioPorRep) {
        PrecioPorRepEntity newPrecio = precioPorRepService.savePrecio(precioPorRep);
        return ResponseEntity.ok(newPrecio);
    }
    @PutMapping("/")
    public ResponseEntity<PrecioPorRepEntity> updatePrecioPorRep(@RequestBody PrecioPorRepEntity employee){
        PrecioPorRepEntity precioPorRepUpdated = precioPorRepService.updatePrecioPorRep(employee);
        return ResponseEntity.ok(precioPorRepUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePrecioPorRepById(@PathVariable Long id) throws Exception {
        var isDeleted= precioPorRepService.deletePrecioPorRep(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/precioByMotorYReparacion/{reparacion}/{tipoDeMotor}")
    public ResponseEntity<Integer> getPrecioByTipoDeMotorYRep(@PathVariable String reparacion,@PathVariable String tipoDeMotor) {
        Integer precio = precioPorRepService.getPrecioByTipoRepYTipoDeMotor(reparacion,tipoDeMotor);
        return ResponseEntity.ok(precio);
    }


}
