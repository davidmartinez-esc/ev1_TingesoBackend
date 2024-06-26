
package com.example.demo.controllers;

import com.example.demo.entities.IngresoARepEntity;
import com.example.demo.services.IngresoARepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/ingresoAReparacion")
@CrossOrigin("*")
public class IngresoARepController {
    @Autowired
    IngresoARepService ingresoARepService;

    @GetMapping("/")
    public ResponseEntity<List<IngresoARepEntity>> listReparaciones() {
        List<IngresoARepEntity> reparaciones = ingresoARepService.getReparaciones();
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping("/")
    public ResponseEntity<IngresoARepEntity> saveReparaciones(@RequestBody IngresoARepEntity reparacion) {
        IngresoARepEntity newReparacion = ingresoARepService.saveReparacion(reparacion);
        return ResponseEntity.ok(newReparacion);
    }





    @PutMapping("/")
    public ResponseEntity<IngresoARepEntity> updateIngresoARep(@RequestBody IngresoARepEntity employee){
        IngresoARepEntity ingresoARepUpdated = ingresoARepService.updateIngresoARep(employee);
        return ResponseEntity.ok(ingresoARepUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIngresoARepById(@PathVariable Long id) throws Exception {
        var isDeleted= ingresoARepService.deleteIngresoARep(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<List<IngresoARepEntity>> getReparacionesByIdVehiculo(@PathVariable int id) {
        List<IngresoARepEntity> reparaciones = ingresoARepService.getReparacionesByIdVehiculo(id);
        return ResponseEntity.ok(reparaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngresoARepEntity> getIngresoARepById(@PathVariable Long id) {
        IngresoARepEntity ingresoARepEntity= ingresoARepService.getIngresoARepById(id);
        return ResponseEntity.ok(ingresoARepEntity);
    }
}

