package com.example.demo.repositories;

import com.example.demo.entities.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity,Long> {

}
