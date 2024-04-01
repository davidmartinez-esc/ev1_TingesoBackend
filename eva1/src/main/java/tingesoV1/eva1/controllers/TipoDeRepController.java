package tingesoV1.eva1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.TipoDeRepEntity;
import tingesoV1.eva1.services.TipoDeRepService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipoDeRep")
@CrossOrigin("*")
public class TipoDeRepController {
    @Autowired
    TipoDeRepService tipoDeRepService;

    @GetMapping("/")
    public ResponseEntity<List<TipoDeRepEntity>> listPaychecks() {
        List<TipoDeRepEntity> tiposDeRep = tipoDeRepService.getReparaciones();
        return ResponseEntity.ok(tiposDeRep);
    }

    @PostMapping("/")
    public ResponseEntity<TipoDeRepEntity> saveTipoDeRep(@RequestBody TipoDeRepEntity tipoDeRep) {
        TipoDeRepEntity tipoDeRepNew = tipoDeRepService.saveTipoDeRep(tipoDeRep);
        return ResponseEntity.ok(tipoDeRepNew);
    }
}
