package com.example.demo.repositories;

import com.example.demo.entities.BonoAplicadoEntity;
import com.example.demo.entities.IngresoARepEntity;
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
public class IngresoARepRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private IngresoARepRepository ingresoARepRepository;


    @Test
    public void whenSearchForIdVehiculo_ThenRetrieveCorrect(){

        Date fechaEjemplo=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 31, 59, 59, 59);
        fechaEjemplo=calendar.getTime();

        LocalTime horaEjemplo=LocalTime.parse("12:12");

        IngresoARepEntity ingresoARepTest=new IngresoARepEntity();

        ingresoARepTest.setId(null);

        ingresoARepTest.setFechaIngreso(fechaEjemplo);
        ingresoARepTest.setHoraIngreso(horaEjemplo);
        ingresoARepTest.setFechaRecogida(fechaEjemplo);
        ingresoARepTest.setHoraRecogida(horaEjemplo);
        ingresoARepTest.setFechaSalida(fechaEjemplo);
        ingresoARepTest.setHoraSalida(horaEjemplo);

        ingresoARepTest.setIdVehiculo(1);
        ingresoARepTest.setCostoTotal(1500000);

        IngresoARepEntity ingresoARepTest2=new IngresoARepEntity();

        ingresoARepTest2.setId(null);

        ingresoARepTest2.setIdVehiculo(1);

        ingresoARepTest2.setFechaIngreso(fechaEjemplo);
        ingresoARepTest2.setHoraIngreso(horaEjemplo);
        ingresoARepTest2.setFechaRecogida(fechaEjemplo);
        ingresoARepTest2.setHoraRecogida(horaEjemplo);
        ingresoARepTest2.setFechaSalida(fechaEjemplo);
        ingresoARepTest2.setHoraSalida(horaEjemplo);

        entityManager.persist(ingresoARepTest);
        entityManager.persist(ingresoARepTest2);
        entityManager.flush();

        // when
        List<IngresoARepEntity> foundIngresos = ingresoARepRepository.findByIdVehiculo(1);

        // then
        assertThat(foundIngresos).hasSize(2).extracting(IngresoARepEntity::getIdVehiculo).containsOnly(1);
    }


}
