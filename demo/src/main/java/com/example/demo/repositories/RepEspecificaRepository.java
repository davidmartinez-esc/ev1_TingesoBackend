package com.example.demo.repositories;



import com.example.demo.entities.IngresoARepEntity;
import com.example.demo.entities.RepEspecificaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepEspecificaRepository extends JpaRepository<RepEspecificaEntity, Long> {


    List<RepEspecificaEntity> findByIdIngresoARep(int idIngresoARep);

    @Query(value = "SELECT SUM(r.precio_de_la_reparacion) FROM reparacion_especifica r WHERE r.id_ingresoarep = :idIngreso", nativeQuery = true)
    Integer getCostoDeLasReparaciones(@Param("idIngreso") int idIngreso);
}
