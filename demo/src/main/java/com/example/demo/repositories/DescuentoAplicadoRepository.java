package com.example.demo.repositories;

import com.example.demo.entities.DescuentoAplicadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoAplicadoRepository extends JpaRepository<DescuentoAplicadoEntity,Long> {
}
