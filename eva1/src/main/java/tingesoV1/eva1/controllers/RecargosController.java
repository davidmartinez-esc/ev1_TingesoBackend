package tingesoV1.eva1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;
import tingesoV1.eva1.services.RecargosService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recargos")
@CrossOrigin("*")
public class RecargosController {
    @Autowired
    RecargosService recargosService;

    @GetMapping("/recargoPorKilometraje/")
    public ResponseEntity<List<RecargoPorKilometrajeEntity>> listRecargoPorKilometrajes() {
        List<RecargoPorKilometrajeEntity> recargoPorKilometraje = recargosService.getRecargosPorKilometraje();
        return ResponseEntity.ok(recargoPorKilometraje);
    }

    @PostMapping("/recargoPorKilometraje/")
    public ResponseEntity<RecargoPorKilometrajeEntity> saveRecargoPorKilometraje(@RequestBody RecargoPorKilometrajeEntity
                                                                                         recargoPorKilometraje) {
        RecargoPorKilometrajeEntity newRecargoPorKilometraje =
                recargosService.saveRecargoPorKilometraje(recargoPorKilometraje);
        return ResponseEntity.ok(newRecargoPorKilometraje);
    }
    @PutMapping("/recargoPorKilometraje/")
    public ResponseEntity<RecargoPorKilometrajeEntity> updateRecargoPorKilometraje(@RequestBody RecargoPorKilometrajeEntity
                                                                                           recargoPorKilometraje){
        RecargoPorKilometrajeEntity recargoPorKilometrajeUpdated = recargosService.updateRecargoPorKilometraje(recargoPorKilometraje);
        return ResponseEntity.ok(recargoPorKilometrajeUpdated);
    }

    @DeleteMapping("/recargoPorKilometraje/{id}")
    public ResponseEntity<Boolean> deleteRecargoPorKilometrajeById(@PathVariable Long id) throws Exception {
        var isDeleted= recargosService.deleteRecargoPorKilometraje(id);
        return ResponseEntity.noContent().build();
    }

    //CONTROLLERS RECARGOS POR ANTIGUEDAD






    @GetMapping("/recargoPorAntiguedad/")
    public ResponseEntity<List<RecargoPorAntiguedadEntity>> listRecargosPorAntiguedad() {
        List<RecargoPorAntiguedadEntity> recargoPorAntiguedad = recargosService.getRecargosPorAntiguedad();
        return ResponseEntity.ok(recargoPorAntiguedad);
    }

    @PostMapping("/recargoPorAntiguedad/")
    public ResponseEntity<RecargoPorAntiguedadEntity> saveRecargoPorAntiguedad(@RequestBody RecargoPorAntiguedadEntity
                                                                                       recargoPorAntiguedad) {
        RecargoPorAntiguedadEntity newRecargoPorAntiguedad =
                recargosService.saveRecargoPorAntiguedad(recargoPorAntiguedad);
        return ResponseEntity.ok(newRecargoPorAntiguedad);
    }
    @PutMapping("/recargoPorAntiguedad/")
    public ResponseEntity<RecargoPorAntiguedadEntity> updateRecargoPorAntiguedad(@RequestBody RecargoPorAntiguedadEntity
                                                                                         recargoPorAntiguedad){
        RecargoPorAntiguedadEntity recargoPorAntiguedadUpdated = recargosService.updateRecargoPorAntiguedad(recargoPorAntiguedad);
        return ResponseEntity.ok(recargoPorAntiguedadUpdated);
    }

    @DeleteMapping("/recargoPorAntiguedad/{id}")
    public ResponseEntity<Boolean> deleteRecargoPorAntiguedadById(@PathVariable Long id) throws Exception {
        var isDeleted= recargosService.deleteRecargoPorAntiguedad(id);
        return ResponseEntity.noContent().build();
    }
}
