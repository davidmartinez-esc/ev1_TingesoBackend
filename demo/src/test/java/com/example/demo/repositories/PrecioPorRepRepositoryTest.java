package com.example.demo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class PrecioPorRepRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PrecioPorRepRepository precioPorRepRepository;

    @Test
    public void whenGetPrecioReparacionMotorGasolina_ThenCorrect(){

        Integer respuesta= precioPorRepRepository.getPrecioRep_MotorGasolina("REP SISTEMA DE FRENOS");


        assertEquals(120000,respuesta.intValue());
    }

    @Test
    public void whenGetPrecioReparacioMotornDiesel_ThenCorrect(){

        Integer respuesta= precioPorRepRepository.getPrecioRep_MotorDiesel("REP SISTEMA DE FRENOS");


        assertEquals(120000,respuesta.intValue());
    }

    @Test
    public void whenGetPrecioReparacioMotornHibrido_ThenCorrect(){

        Integer respuesta= precioPorRepRepository.getPrecioRep_MotorHibrido("REP SISTEMA DE FRENOS");


        assertEquals(180000,respuesta.intValue());
    }

    @Test
    public void whenGetPrecioReparacioMotornElectrico_ThenCorrect(){

        Integer respuesta= precioPorRepRepository.getPrecioRep_MotorElectrico("REP SISTEMA DE FRENOS");


        assertEquals(220000,respuesta.intValue());
    }
}
