package tingesoV1.eva1.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tingesoV1.eva1.entities.PrecioPorRepEntity;
import tingesoV1.eva1.repositories.PrecioPorRepRepository;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class PrecioPorRepServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private PrecioPorRepRepository precioPorRepRepository;

    @InjectMocks
    private PrecioPorRepService precioPorRepService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetPrecioPorRep_thenCorrect(){

        PrecioPorRepEntity precioPorRepTest=new PrecioPorRepEntity();

        precioPorRepTest.setId(1L);
        precioPorRepTest.setNombreDeLaRep("REPARACION ESTRUCTURAL");
        precioPorRepTest.setPrecioDiesel(200000);
        precioPorRepTest.setPrecioElectrico(200000);
        precioPorRepTest.setPrecioHibrido(200000);
        precioPorRepTest.setPrecioGasolina(12000);

        PrecioPorRepEntity precioPorRepTest2=new PrecioPorRepEntity();
        precioPorRepTest.setId(2L);
        precioPorRepTest.setNombreDeLaRep("LIMPIEZA MINUCIOSA");
        precioPorRepTest.setPrecioDiesel(200000);
        precioPorRepTest.setPrecioElectrico(200000);
        precioPorRepTest.setPrecioHibrido(200000);
        precioPorRepTest.setPrecioGasolina(12000);

        ArrayList<PrecioPorRepEntity> precioPorRepsLista=new ArrayList<>();

        precioPorRepsLista.add(precioPorRepTest);
        precioPorRepsLista.add(precioPorRepTest2);

        when(precioPorRepRepository.findAll()).thenReturn(precioPorRepsLista);

        ArrayList<PrecioPorRepEntity> resultado = precioPorRepService.getAllPrecios();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSavePrecioPorRep_thenCorrect(){
        PrecioPorRepEntity precioPorRepTest=new PrecioPorRepEntity();

        precioPorRepTest.setId(1L);
        precioPorRepTest.setNombreDeLaRep("REPARACION ESTRUCTURAL");
        precioPorRepTest.setPrecioDiesel(200000);
        precioPorRepTest.setPrecioElectrico(200000);
        precioPorRepTest.setPrecioHibrido(200000);
        precioPorRepTest.setPrecioGasolina(12000);

        when(precioPorRepRepository.save(precioPorRepTest)).thenReturn(precioPorRepTest);

        PrecioPorRepEntity precioPorRepResponse=precioPorRepService.savePrecio(precioPorRepTest);

        assertEquals(precioPorRepResponse,precioPorRepTest);
    }

    @Test
    public void whenUpdatePrecioPorRep_thenCorrect(){
        PrecioPorRepEntity precioPorRepTest=new PrecioPorRepEntity();



        precioPorRepTest.setId(1L);
        precioPorRepTest.setNombreDeLaRep("REPARACION ESTRUCTURAL");
        precioPorRepTest.setPrecioDiesel(200000);
        precioPorRepTest.setPrecioElectrico(200000);
        precioPorRepTest.setPrecioHibrido(200000);
        precioPorRepTest.setPrecioGasolina(12000);


        when(precioPorRepRepository.save(precioPorRepTest)).thenReturn(precioPorRepTest);

        PrecioPorRepEntity precioPorRepUpdated=precioPorRepService.updatePrecioPorRep(precioPorRepTest);

        assertEquals(precioPorRepUpdated,precioPorRepTest);
    }

    @Test
    public void testDeletePrecioPorRep() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = precioPorRepService.deletePrecioPorRep(id);
        // Assert
        assertTrue(result);
        verify(precioPorRepRepository, times(1)).deleteById(id);
    }
}
