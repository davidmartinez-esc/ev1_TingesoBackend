package tingesoV1.eva1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.VehiculoEntity;
import tingesoV1.eva1.services.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculo")
@CrossOrigin("*")
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
}
