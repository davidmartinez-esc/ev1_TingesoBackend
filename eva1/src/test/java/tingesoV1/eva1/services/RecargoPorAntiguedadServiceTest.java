package tingesoV1.eva1.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.repositories.RecargoPorAntiguedadRepository;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class RecargoPorAntiguedadServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private RecargoPorAntiguedadRepository recargoPorAntiguedadRepository;

    @InjectMocks
    private RecargoPorAntiguedadService recargoPorAntiguedadService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetRecargoPorAntiguedad_thenCorrect(){

        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=new RecargoPorAntiguedadEntity();


        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("0-5");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("SEDAN");

        RecargoPorAntiguedadEntity recargoPorAntiguedadTest2=new RecargoPorAntiguedadEntity();
        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("0-5");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("HATCHBACK");

        ArrayList<RecargoPorAntiguedadEntity> recargoPorAntiguedadsLista=new ArrayList<>();

        recargoPorAntiguedadsLista.add(recargoPorAntiguedadTest);
        recargoPorAntiguedadsLista.add(recargoPorAntiguedadTest2);

        when(recargoPorAntiguedadRepository.findAll()).thenReturn(recargoPorAntiguedadsLista);

        ArrayList<RecargoPorAntiguedadEntity> resultado = recargoPorAntiguedadService.getRecargosPorAntiguedad();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveRecargoPorAntiguedad_thenCorrect(){
        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("0-5");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorAntiguedadRepository.save(recargoPorAntiguedadTest)).thenReturn(recargoPorAntiguedadTest);

        RecargoPorAntiguedadEntity recargoPorAntiguedadResponse=recargoPorAntiguedadService.saveRecargoPorAntiguedad(recargoPorAntiguedadTest);

        assertEquals(recargoPorAntiguedadResponse,recargoPorAntiguedadTest);
    }

    @Test
    public void whenUpdateRecargoPorAntiguedad_thenCorrect(){
        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("0-5");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorAntiguedadRepository.save(recargoPorAntiguedadTest)).thenReturn(recargoPorAntiguedadTest);

        RecargoPorAntiguedadEntity recargoPorAntiguedadUpdated=recargoPorAntiguedadService.updateRecargoPorAntiguedad(recargoPorAntiguedadTest);

        assertEquals(recargoPorAntiguedadUpdated,recargoPorAntiguedadTest);
    }

    @Test
    public void testDeleteRecargoPorAntiguedad() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = recargoPorAntiguedadService.deleteRecargoPorAntiguedad(id);
        // Assert
        assertTrue(result);
        verify(recargoPorAntiguedadRepository, times(1)).deleteById(id);
    }
}
