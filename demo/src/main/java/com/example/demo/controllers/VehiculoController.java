package com.example.demo.controllers;

import com.example.demo.entities.VehiculoEntity;
import com.example.demo.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculo")
@CrossOrigin(origins = "*")
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @GetMapping("/")
    public ResponseEntity<List<VehiculoEntity>> listVehiculos() {
        List<VehiculoEntity> vehiculo = vehiculoService.getVehiculos();
        return ResponseEntity.ok(vehiculo);
    }

    @PostMapping("/")
    public ResponseEntity<VehiculoEntity> saveVehiculo(@RequestBody VehiculoEntity vehiculo) {
        VehiculoEntity newVehiculo = vehiculoService.saveVehiculo(vehiculo);
        return ResponseEntity.ok(newVehiculo);
    }
    @PutMapping("/")
    public ResponseEntity<VehiculoEntity> updateVehiculo(@RequestBody VehiculoEntity vehiculo){
        VehiculoEntity vehiculoUpdated = vehiculoService.updateVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteVehiculoById(@PathVariable Long id) throws Exception {
        var isDeleted= vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }

}
