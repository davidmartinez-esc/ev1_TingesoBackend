package tingesoV1.eva1.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class RecargoporKilometrajeRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecargoPorKilometrajeRepository recargoPorKilometrajeRepository;

    @Test
    public void whenFindRecargoPorKilometraje_(){

        int recargoTest=
                recargoPorKilometrajeRepository.
                        getRecargoByKilmetrajeYTipoDeVehiculo("40.000-MAS","SEDAN");
        assertEquals(20,recargoTest);
    }
}
