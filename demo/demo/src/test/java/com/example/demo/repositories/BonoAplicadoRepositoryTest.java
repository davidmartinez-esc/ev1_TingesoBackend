package com.example.demo.repositories;

import com.example.demo.entities.BonoAplicadoEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@ActiveProfiles("test")
public class BonoAplicadoRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private BonoAplicadoRepository bonoAplicadoRepository;


    @Test
    public void getNumeroDeBonos_ThenCorrect(){
        BonoAplicadoEntity bonoAplicado=new BonoAplicadoEntity(null,250000,1);

        entityManager.persistAndFlush(bonoAplicado);
    }
}
