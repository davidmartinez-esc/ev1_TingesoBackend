package tingesoV1.eva1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.RepEspecificaEntity;
import tingesoV1.eva1.services.RepEspecificaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repEspecifica")
@CrossOrigin("*")
public class RepEspecificaController {
    @Autowired
    RepEspecificaService repEspecificaService;

    @GetMapping("/")
    public ResponseEntity<List<RepEspecificaEntity>> listAllRepsecificas() {
        List<RepEspecificaEntity> tiposDeRep = repEspecificaService.getAllReparacionesEspecificas();
        return ResponseEntity.ok(tiposDeRep);
    }

    @PostMapping("/")
    public ResponseEntity<RepEspecificaEntity> saveRepEspecifica(@RequestBody RepEspecificaEntity tipoDeRep) {
        RepEspecificaEntity tipoDeRepNew = repEspecificaService.saveTipoDeRep(tipoDeRep);
        return ResponseEntity.ok(tipoDeRepNew);
    }
}
