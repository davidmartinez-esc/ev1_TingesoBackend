
package tingesoV1.eva1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.IngresoARepEntity;
import tingesoV1.eva1.services.IngresoARepService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticketReparacion")
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
}

