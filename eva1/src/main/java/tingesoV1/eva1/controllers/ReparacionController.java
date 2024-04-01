package tingesoV1.eva1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.ReparacionEntity;
import tingesoV1.eva1.services.ReparacionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reparacion")
@CrossOrigin("*")
public class ReparacionController {
    @Autowired
    ReparacionService reparacionService;

    @GetMapping("/")
    public ResponseEntity<List<ReparacionEntity>> listReparaciones() {
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping("/")
    public ResponseEntity<ReparacionEntity> saveReparaciones(@RequestBody ReparacionEntity reparacion) {
        ReparacionEntity newReparacion = reparacionService.saveReparacion(reparacion);
        return ResponseEntity.ok(newReparacion);
    }
}
