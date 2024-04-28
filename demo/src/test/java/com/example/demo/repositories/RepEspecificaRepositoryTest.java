package com.example.demo.repositories;

import com.example.demo.entities.IngresoARepEntity;
import com.example.demo.entities.RepEspecificaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
public class RepEspecificaRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private RepEspecificaRepository repEspecificaRepository;


    @Test
    public void whenSearchForIdIngreso_ThenReturnCorrect(){

        RepEspecificaEntity repEspecificaTest=new RepEspecificaEntity();


        repEspecificaTest.setId(null);
        repEspecificaTest.setIdIngresoARep(1);
        repEspecificaTest.setPrecioDeLaReparacion(125000);
        repEspecificaTest.setNombreDeLaRep("REP ELECTRICA");



        RepEspecificaEntity repEspecificaTest2=new RepEspecificaEntity();

        repEspecificaTest2.setId(null);
        repEspecificaTest2.setIdIngresoARep(1);
        repEspecificaTest2.setPrecioDeLaReparacion(122000);
        repEspecificaTest2.setNombreDeLaRep("REP ELECTRICA");


        entityManager.persist(repEspecificaTest);
        entityManager.persist(repEspecificaTest2);
        entityManager.flush();

        // when
        List<RepEspecificaEntity> repsEncontradas = repEspecificaRepository.findByIdIngresoARep(1);

        // then
        assertThat(repsEncontradas).hasSize(2).extracting(RepEspecificaEntity::getIdIngresoARep).
                containsOnly(1);
    }


}
