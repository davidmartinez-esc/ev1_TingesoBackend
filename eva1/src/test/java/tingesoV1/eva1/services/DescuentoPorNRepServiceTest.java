package tingesoV1.eva1.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tingesoV1.eva1.entities.DescuentoPorNRepEntity;
import tingesoV1.eva1.repositories.DescuentoPorNRepRepository;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class DescuentoPorNRepServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private DescuentoPorNRepRepository descuentoPorNRepRepository;

    @InjectMocks
    private DescuentoPorNRepService descuentoPorNRepService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetDescuentoPorNRep_thenCorrect(){

        DescuentoPorNRepEntity descuentoPorNRepTest=new DescuentoPorNRepEntity();


        descuentoPorNRepTest.setId(1L);
        descuentoPorNRepTest.setNumeroDeReparaciones("0-2");
        descuentoPorNRepTest.setPorcentajeDescuento(15);
        descuentoPorNRepTest.setTipoDeMotor("ELECTRICO");


        DescuentoPorNRepEntity descuentoPorNRepTest2=new DescuentoPorNRepEntity();


        descuentoPorNRepTest.setId(2L);
        descuentoPorNRepTest.setNumeroDeReparaciones("0-2");
        descuentoPorNRepTest.setPorcentajeDescuento(15);
        descuentoPorNRepTest.setTipoDeMotor("DIESEL");

        ArrayList<DescuentoPorNRepEntity> descuentoPorNRepsLista=new ArrayList<>();

        descuentoPorNRepsLista.add(descuentoPorNRepTest);
        descuentoPorNRepsLista.add(descuentoPorNRepTest2);

        when(descuentoPorNRepRepository.findAll()).thenReturn(descuentoPorNRepsLista);

        ArrayList<DescuentoPorNRepEntity> resultado = descuentoPorNRepService.getDescuentoPorNReps();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveDescuentoPorNRep_thenCorrect(){
        DescuentoPorNRepEntity descuentoPorNRepTest=new DescuentoPorNRepEntity();

        descuentoPorNRepTest.setId(1L);
        descuentoPorNRepTest.setNumeroDeReparaciones("0-2");
        descuentoPorNRepTest.setPorcentajeDescuento(15);
        descuentoPorNRepTest.setTipoDeMotor("ELECTRICO");

        when(descuentoPorNRepRepository.save(descuentoPorNRepTest)).thenReturn(descuentoPorNRepTest);

        DescuentoPorNRepEntity descuentoPorNRepResponse=descuentoPorNRepService.saveDescuentoPorNRep(descuentoPorNRepTest);

        assertEquals(descuentoPorNRepResponse,descuentoPorNRepTest);
    }

    @Test
    public void whenUpdateDescuentoPorNRep_thenCorrect(){
        DescuentoPorNRepEntity descuentoPorNRepTest=new DescuentoPorNRepEntity();


        descuentoPorNRepTest.setId(1L);
        descuentoPorNRepTest.setNumeroDeReparaciones("0-2");
        descuentoPorNRepTest.setPorcentajeDescuento(15);
        descuentoPorNRepTest.setTipoDeMotor("ELECTRICO");

        when(descuentoPorNRepRepository.save(descuentoPorNRepTest)).thenReturn(descuentoPorNRepTest);

        DescuentoPorNRepEntity descuentoPorNRepUpdated=descuentoPorNRepService.updateDescuentoPorNRep(descuentoPorNRepTest);

        assertEquals(descuentoPorNRepUpdated,descuentoPorNRepTest);
    }

    @Test
    public void testDeleteDescuentoPorNRep() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = descuentoPorNRepService.deleteDescuentoPorNRep(id);
        // Assert
        assertTrue(result);
        verify(descuentoPorNRepRepository, times(1)).deleteById(id);
    }
}
