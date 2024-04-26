package com.example.demo.controllers;


import com.example.demo.entities.RepEspecificaEntity;
import com.example.demo.services.RepEspecificaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @PutMapping("/")
    public ResponseEntity<RepEspecificaEntity> updateRepEspecifica(@RequestBody RepEspecificaEntity repEspecifica){
        RepEspecificaEntity repEspecificaUpdated = repEspecificaService.updateRepEspecifica(repEspecifica);
        return ResponseEntity.ok(repEspecificaUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRepEspecificaById(@PathVariable Long id) throws Exception {
        var isDeleted= repEspecificaService.deleteRepEspecifica(id);
        return ResponseEntity.noContent().build();
    }
}
