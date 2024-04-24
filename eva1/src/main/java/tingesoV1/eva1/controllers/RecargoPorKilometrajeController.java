package tingesoV1.eva1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;
import tingesoV1.eva1.services.RecargoPorKilometrajeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recargoPorKilometraje")
@CrossOrigin("*")
public class RecargoPorKilometrajeController {
    @Autowired
    RecargoPorKilometrajeService recargoPorKilometrajeService;

    @GetMapping("/")
    public ResponseEntity<List<RecargoPorKilometrajeEntity>> listRecargoPorKilometrajes() {
        List<RecargoPorKilometrajeEntity> recargoPorKilometraje = recargoPorKilometrajeService.getRecargosPorKilometraje();
        return ResponseEntity.ok(recargoPorKilometraje);
    }

    @PostMapping("/")
    public ResponseEntity<RecargoPorKilometrajeEntity> saveRecargoPorKilometraje(@RequestBody RecargoPorKilometrajeEntity
                                                                                             recargoPorKilometraje) {
        RecargoPorKilometrajeEntity newRecargoPorKilometraje =
                recargoPorKilometrajeService.saveRecargoPorKilometraje(recargoPorKilometraje);
        return ResponseEntity.ok(newRecargoPorKilometraje);
    }
    @PutMapping("/")
    public ResponseEntity<RecargoPorKilometrajeEntity> updateRecargoPorKilometraje(@RequestBody RecargoPorKilometrajeEntity
                                                                                               recargoPorKilometraje){
        RecargoPorKilometrajeEntity recargoPorKilometrajeUpdated = recargoPorKilometrajeService.updateRecargoPorKilometraje(recargoPorKilometraje);
        return ResponseEntity.ok(recargoPorKilometrajeUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecargoPorKilometrajeById(@PathVariable Long id) throws Exception {
        var isDeleted= recargoPorKilometrajeService.deleteRecargoPorKilometraje(id);
        return ResponseEntity.noContent().build();
    }
}
