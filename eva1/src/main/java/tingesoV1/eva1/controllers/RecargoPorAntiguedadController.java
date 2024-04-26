package tingesoV1.eva1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.services.RecargoPorAntiguedadService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recargoPorAntiguedad")
@CrossOrigin("*")
public class RecargoPorAntiguedadController {
    @Autowired
    RecargoPorAntiguedadService recargoPorAntiguedadService;

    @GetMapping("/")
    public ResponseEntity<List<RecargoPorAntiguedadEntity>> listRecargosPorAntiguedad() {
        List<RecargoPorAntiguedadEntity> recargoPorAntiguedad = recargoPorAntiguedadService.getRecargosPorAntiguedad();
        return ResponseEntity.ok(recargoPorAntiguedad);
    }

    @PostMapping("/")
    public ResponseEntity<RecargoPorAntiguedadEntity> saveRecargoPorAntiguedad(@RequestBody RecargoPorAntiguedadEntity
                                                                                         recargoPorAntiguedad) {
        RecargoPorAntiguedadEntity newRecargoPorAntiguedad =
                recargoPorAntiguedadService.saveRecargoPorAntiguedad(recargoPorAntiguedad);
        return ResponseEntity.ok(newRecargoPorAntiguedad);
    }
    @PutMapping("/")
    public ResponseEntity<RecargoPorAntiguedadEntity> updateRecargoPorAntiguedad(@RequestBody RecargoPorAntiguedadEntity
                                                                                           recargoPorAntiguedad){
        RecargoPorAntiguedadEntity recargoPorAntiguedadUpdated = recargoPorAntiguedadService.updateRecargoPorAntiguedad(recargoPorAntiguedad);
        return ResponseEntity.ok(recargoPorAntiguedadUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecargoPorAntiguedadById(@PathVariable Long id) throws Exception {
        var isDeleted= recargoPorAntiguedadService.deleteRecargoPorAntiguedad(id);
        return ResponseEntity.noContent().build();
    }
}