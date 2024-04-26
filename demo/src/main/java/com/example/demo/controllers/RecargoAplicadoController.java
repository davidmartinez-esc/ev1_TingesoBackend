package com.example.demo.controllers;

import com.example.demo.entities.RecargoAplicadoEntity;
import com.example.demo.services.RecargoAplicadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/recargoAplicado")
@CrossOrigin("*")
public class RecargoAplicadoController {
    @Autowired
    RecargoAplicadoService recargoAplicadoService;

    @GetMapping("/")
    public ResponseEntity<List<RecargoAplicadoEntity>> listRecargosAplicados() {
        List<RecargoAplicadoEntity> recargoAplicado = recargoAplicadoService.getRecargosAplicados();
        return ResponseEntity.ok(recargoAplicado);
    }

    @PostMapping("/")
    public ResponseEntity<RecargoAplicadoEntity> saveRecargoAplicado(@RequestBody RecargoAplicadoEntity recargoAplicado) {
        RecargoAplicadoEntity newRecargoAplicado = recargoAplicadoService.saveRecargoAplicado(recargoAplicado);
        return ResponseEntity.ok(newRecargoAplicado);
    }
    @PutMapping("/")
    public ResponseEntity<RecargoAplicadoEntity> updateRecargoAplicado(@RequestBody RecargoAplicadoEntity recargoAplicado){
        RecargoAplicadoEntity recargoAplicadoUpdated = recargoAplicadoService.updateRecargoAplicado(recargoAplicado);
        return ResponseEntity.ok(recargoAplicadoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecargoAplicadoById(@PathVariable Long id) throws Exception {
        var isDeleted= recargoAplicadoService.deleteRecargoAplicado(id);
        return ResponseEntity.noContent().build();
    }
}
