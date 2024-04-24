package tingesoV1.eva1.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;
import tingesoV1.eva1.repositories.RecargoPorKilometrajeRepository;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class RecargoPorKilometrajeServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private RecargoPorKilometrajeRepository recargoPorKilometrajeRepository;

    @InjectMocks
    private RecargoPorKilometrajeService recargoPorKilometrajeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetRecargoPorKilometraje_thenCorrect(){

        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=new RecargoPorKilometrajeEntity();


      recargoPorKilometrajeTest.setId(1L);
      recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
      recargoPorKilometrajeTest.setPorcentajeRecargo(15);
      recargoPorKilometrajeTest.setTipoDeVehiculo("SEDAN");

        RecargoPorKilometrajeEntity recargoPorKilometrajeTest2=new RecargoPorKilometrajeEntity();
        recargoPorKilometrajeTest.setId(2L);
        recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest.setTipoDeVehiculo("PICKUP");

        ArrayList<RecargoPorKilometrajeEntity> recargoPorKilometrajesLista=new ArrayList<>();

        recargoPorKilometrajesLista.add(recargoPorKilometrajeTest);
        recargoPorKilometrajesLista.add(recargoPorKilometrajeTest2);

        when(recargoPorKilometrajeRepository.findAll()).thenReturn(recargoPorKilometrajesLista);

        ArrayList<RecargoPorKilometrajeEntity> resultado = recargoPorKilometrajeService.getRecargosPorKilometraje();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveRecargoPorKilometraje_thenCorrect(){
        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=new RecargoPorKilometrajeEntity();

        recargoPorKilometrajeTest.setId(1L);
        recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorKilometrajeRepository.save(recargoPorKilometrajeTest)).thenReturn(recargoPorKilometrajeTest);

        RecargoPorKilometrajeEntity recargoPorKilometrajeResponse=
                recargoPorKilometrajeService.saveRecargoPorKilometraje(recargoPorKilometrajeTest);

        assertEquals(recargoPorKilometrajeResponse,recargoPorKilometrajeTest);
    }

    @Test
    public void whenUpdateRecargoPorKilometraje_thenCorrect(){
        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=new RecargoPorKilometrajeEntity();

        recargoPorKilometrajeTest.setId(1L);
        recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorKilometrajeRepository.save(recargoPorKilometrajeTest)).thenReturn(recargoPorKilometrajeTest);

        RecargoPorKilometrajeEntity recargoPorKilometrajeUpdated=recargoPorKilometrajeService.updateRecargoPorKilometraje(recargoPorKilometrajeTest);

        assertEquals(recargoPorKilometrajeUpdated,recargoPorKilometrajeTest);
    }

    @Test
    public void testDeleteRecargoPorKilometraje() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = recargoPorKilometrajeService.deleteRecargoPorKilometraje(id);
        // Assert
        assertTrue(result);
        verify(recargoPorKilometrajeRepository, times(1)).deleteById(id);
    }
}
