package com.example.demo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class RecargoPorAntiguedadRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecargoPorAntiguedadRepository recargoPorAntiguedadRepository;

    @Test
    public void whenFindByAntiguedadTipo_ThenCorrect(){

        int recargoTest=
                recargoPorAntiguedadRepository.getRecargoByAntiguedadPorTipo("16-MAS","SEDAN");
        assertEquals(15,recargoTest);
    }
}
