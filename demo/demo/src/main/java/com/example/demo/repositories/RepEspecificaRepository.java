package com.example.demo.repositories;



import com.example.demo.entities.RepEspecificaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepEspecificaRepository extends JpaRepository<RepEspecificaEntity, Long> {

}
