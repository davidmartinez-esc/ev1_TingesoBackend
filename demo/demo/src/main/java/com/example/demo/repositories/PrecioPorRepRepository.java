package com.example.demo.repositories;

import com.example.demo.entities.PrecioPorRepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import tingesoV1.eva1.entities.PrecioPorRepEntity;

@Repository
public interface PrecioPorRepRepository extends JpaRepository<PrecioPorRepEntity,Long> {
    @Query(value = "SELECT precio_gasolina FROM precio_reparacion WHERE nombre_de_la_rep = :nombre_rep", nativeQuery = true)
    Integer getPrecioRep_MotorGasolina(@Param("nombre_rep") String nombre_rep);

    @Query(value = "SELECT precio_diesel FROM precio_reparacion WHERE nombre_de_la_rep = :nombre_rep", nativeQuery = true)
    Integer getPrecioRep_MotorDiesel(@Param("nombre_rep") String nombre_rep);

    @Query(value = "SELECT precio_electrico FROM precio_reparacion WHERE nombre_de_la_rep = :nombre_rep", nativeQuery = true)
    Integer getPrecioRep_MotorElectrico(@Param("nombre_rep") String nombre_rep);

    @Query(value = "SELECT precio_hibrido FROM precio_reparacion WHERE nombre_de_la_rep = :nombre_rep", nativeQuery = true)
    Integer getPrecioRep_MotorHibrido(@Param("nombre_rep") String nombre_rep);


}
