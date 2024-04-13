package tingesoV1.eva1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesoV1.eva1.entities.BonoAplicadoEntity;
import tingesoV1.eva1.entities.DescuentoAplicadoEntity;
import tingesoV1.eva1.entities.RecargoAplicadoEntity;
import tingesoV1.eva1.services.AplicadosAPrecioService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/aplicadosAPrecio")
@CrossOrigin("*")
public class AplicadosAPrecioController {
    @Autowired
    AplicadosAPrecioService aplicadosAPrecioService;

    @GetMapping("/recargosAplicados/")
    public ResponseEntity<List<RecargoAplicadoEntity>> listRecargosAplicados() {
        List<RecargoAplicadoEntity> recargoAplicado = aplicadosAPrecioService.getRecargosAplicados();
        return ResponseEntity.ok(recargoAplicado);
    }

    @PostMapping("/recargosAplicados/")
    public ResponseEntity<RecargoAplicadoEntity> saveRecargoAplicado(@RequestBody RecargoAplicadoEntity recargoAplicado) {
        RecargoAplicadoEntity newRecargoAplicado = aplicadosAPrecioService.saveRecargoAplicado(recargoAplicado);
        return ResponseEntity.ok(newRecargoAplicado);
    }
    @PutMapping("/recargosAplicados/")
    public ResponseEntity<RecargoAplicadoEntity> updateRecargoAplicado(@RequestBody RecargoAplicadoEntity recargoAplicado){
        RecargoAplicadoEntity recargoAplicadoUpdated = aplicadosAPrecioService.updateRecargoAplicado(recargoAplicado);
        return ResponseEntity.ok(recargoAplicadoUpdated);
    }

    @DeleteMapping("/recargosAplicados/{id}")
    public ResponseEntity<Boolean> deleteRecargoAplicadoById(@PathVariable Long id) throws Exception {
        var isDeleted= aplicadosAPrecioService.deleteRecargoAplicado(id);
        return ResponseEntity.noContent().build();
    }
    //DESCUENTOAPLICADO CONTROLLER





    @GetMapping("/descuentosAplicados/")
    public ResponseEntity<List<DescuentoAplicadoEntity>> listDescuentosAplicados() {
        List<DescuentoAplicadoEntity> descuentoAplicado = aplicadosAPrecioService.getDescuentosAplicados();
        return ResponseEntity.ok(descuentoAplicado);
    }

    @PostMapping("/descuentosAplicados/")
    public ResponseEntity<DescuentoAplicadoEntity> saveDescuentoAplicado(@RequestBody DescuentoAplicadoEntity descuentoAplicado) {
        DescuentoAplicadoEntity newDescuentoAplicado = aplicadosAPrecioService.saveDescuentoAplicado(descuentoAplicado);
        return ResponseEntity.ok(newDescuentoAplicado);
    }
    @PutMapping("/descuentosAplicados/")
    public ResponseEntity<DescuentoAplicadoEntity> updateDescuentoAplicado(@RequestBody DescuentoAplicadoEntity descuentoAplicado){
        DescuentoAplicadoEntity descuentoAplicadoUpdated = aplicadosAPrecioService.updateDescuentoAplicado(descuentoAplicado);
        return ResponseEntity.ok(descuentoAplicadoUpdated);
    }

    @DeleteMapping("/descuentosAplicados/{id}")
    public ResponseEntity<Boolean> deleteDescuentoAplicadoById(@PathVariable Long id) throws Exception {
        var isDeleted= aplicadosAPrecioService.deleteDescuentoAplicado(id);
        return ResponseEntity.noContent().build();
    }


    //BONO APLICADO-----------------------------------------------



    @GetMapping("/bonosAplicados/")
    public ResponseEntity<List<BonoAplicadoEntity>> listBonosAplicados() {
        List<BonoAplicadoEntity> bonosAplicados = aplicadosAPrecioService.getBonosAplicados();
        return ResponseEntity.ok(bonosAplicados);
    }

    @PostMapping("/bonosAplicados/")
    public ResponseEntity<BonoAplicadoEntity> saveBonoAplicado(@RequestBody BonoAplicadoEntity bonoAplicadoEntity) {
        BonoAplicadoEntity newBonoAplicado = aplicadosAPrecioService.saveBonoAplicado(bonoAplicadoEntity);
        return ResponseEntity.ok(newBonoAplicado);
    }
    @PutMapping("/bonosAplicados/")
    public ResponseEntity<BonoAplicadoEntity> updateDescuentoAplicado(@RequestBody BonoAplicadoEntity bonoAplicado){
        BonoAplicadoEntity bonoAplicadoUpdated = aplicadosAPrecioService.updateBonoAplicado(bonoAplicado);
        return ResponseEntity.ok(bonoAplicadoUpdated);
    }

    @DeleteMapping("/bonosAplicados/{id}")
    public ResponseEntity<Boolean> deleteBonoAplicadoById(@PathVariable Long id) throws Exception {
        var isDeleted= aplicadosAPrecioService.deleteBonoAplicado(id);
        return ResponseEntity.noContent().build();
    }



}
