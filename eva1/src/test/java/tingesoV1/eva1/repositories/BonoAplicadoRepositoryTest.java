package tingesoV1.eva1.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import tingesoV1.eva1.entities.BonoAplicadoEntity;
import tingesoV1.eva1.entities.IngresoARepEntity;
import tingesoV1.eva1.entities.VehiculoEntity;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
//@RunWith(SpringRunner.class)
public class BonoAplicadoRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private BonoAplicadoRepository bonoAplicadoRepository;


    @Test
    public void getNumeroDeBonos_ThenCorrect(){
        BonoAplicadoEntity bonoAplicado=new BonoAplicadoEntity(null,250000,1);

        //entityManager.persistAndFlush(bonoAplicado);
    }
}
