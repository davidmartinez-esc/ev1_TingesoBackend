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
        precioPorRepTest2.setId(2L);
        precioPorRepTest2.setNombreDeLaRep("LIMPIEZA MINUCIOSA");
        precioPorRepTest2.setPrecioDiesel(200000);
        precioPorRepTest2.setPrecioElectrico(200000);
        precioPorRepTest2.setPrecioHibrido(200000);
        precioPorRepTest2.setPrecioGasolina(12000);

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

    @Test(expected= Exception.class)
    public void testDeleteprecioPorRepException() throws Exception {
        doThrow(IllegalStateException.class).when(precioPorRepRepository).deleteById(1L);

        boolean response=precioPorRepService.deletePrecioPorRep(1L);

    }

    @Test
    public void test_getPrecioByTipoRepYMotorDiesel(){
        when(precioPorRepRepository.getPrecioRep_MotorDiesel(anyString())).thenReturn(12000);

        int response_Diesel=
                precioPorRepService.getPrecioByTipoRepYTipoDeMotor("REP ELECTRICA","DIESEL");

        assertEquals(12000,response_Diesel);


    }

    @Test
    public void test_getPrecioByTipoRepYMotorElectrico(){
        when(precioPorRepRepository.getPrecioRep_MotorElectrico(anyString())).thenReturn(20000);
        int response_Electrico=
                precioPorRepService.getPrecioByTipoRepYTipoDeMotor("REP ELECTRICA","ELECTRICO");
        assertEquals(20000,response_Electrico);

    }

    @Test
    public void test_getPrecioByTipoRepYMotoreGasolina(){
        when(precioPorRepRepository.getPrecioRep_MotorGasolina(anyString())).thenReturn(30000);
        int response_Gasolina=
                precioPorRepService.getPrecioByTipoRepYTipoDeMotor("REP ELECTRICA","GASOLINA");

        assertEquals(30000,response_Gasolina);
    }

    @Test
    public void test_getPrecioByTipoRepYMotoreHibrido(){
        when(precioPorRepRepository.getPrecioRep_MotorHibrido(anyString())).thenReturn(40000);
        int response_Hibrido=
                precioPorRepService.getPrecioByTipoRepYTipoDeMotor("REP ELECTRICA","HIBRIDO");

        assertEquals(40000,response_Hibrido);

    }

}
