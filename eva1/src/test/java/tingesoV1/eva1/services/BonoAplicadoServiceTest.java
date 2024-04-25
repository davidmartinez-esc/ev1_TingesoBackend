package tingesoV1.eva1.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tingesoV1.eva1.entities.BonoAplicadoEntity;
import tingesoV1.eva1.repositories.BonoAplicadoRepository;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class BonoAplicadoServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private BonoAplicadoRepository bonoAplicadoRepository;

    @InjectMocks
    private BonoAplicadoService bonoAplicadoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetBonoAplicado_thenCorrect(){

        BonoAplicadoEntity bonoAplicadoTest=new BonoAplicadoEntity();


        bonoAplicadoTest.setId(1L);
        bonoAplicadoTest.setMonto(12000);
        bonoAplicadoTest.setIdIngreso(1);

        BonoAplicadoEntity bonoAplicadoTest2=new BonoAplicadoEntity();

        bonoAplicadoTest2.setId(2L);
        bonoAplicadoTest2.setMonto(122000);
        bonoAplicadoTest2.setIdIngreso(2);


        ArrayList<BonoAplicadoEntity> bonoAplicadosLista=new ArrayList<>();

        bonoAplicadosLista.add(bonoAplicadoTest);
        bonoAplicadosLista.add(bonoAplicadoTest2);

        when(bonoAplicadoRepository.findAll()).thenReturn(bonoAplicadosLista);

        ArrayList<BonoAplicadoEntity> resultado = bonoAplicadoService.getBonosAplicados();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveBonoAplicado_thenCorrect(){
        BonoAplicadoEntity bonoAplicadoTest=new BonoAplicadoEntity();


        bonoAplicadoTest.setId(1L);
        bonoAplicadoTest.setMonto(12000);
        bonoAplicadoTest.setIdIngreso(1);

        when(bonoAplicadoRepository.save(bonoAplicadoTest)).thenReturn(bonoAplicadoTest);

        BonoAplicadoEntity bonoAplicadoResponse=bonoAplicadoService.saveBonoAplicado(bonoAplicadoTest);

        assertEquals(bonoAplicadoResponse,bonoAplicadoTest);
    }

    @Test
    public void whenUpdateBonoAplicado_thenCorrect(){
        BonoAplicadoEntity bonoAplicadoTest=new BonoAplicadoEntity();

        bonoAplicadoTest.setId(1L);
        bonoAplicadoTest.setMonto(12000);
        bonoAplicadoTest.setIdIngreso(1);



        when(bonoAplicadoRepository.save(bonoAplicadoTest)).thenReturn(bonoAplicadoTest);

        BonoAplicadoEntity bonoAplicadoUpdated=bonoAplicadoService.updateBonoAplicado(bonoAplicadoTest);

        assertEquals(bonoAplicadoUpdated,bonoAplicadoTest);
    }

    @Test
    public void testDeleteBonoAplicado() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = bonoAplicadoService.deleteBonoAplicado(id);
        // Assert
        assertTrue(result);
        verify(bonoAplicadoRepository, times(1)).deleteById(id);
    }
    @Test(expected= Exception.class)
    public void testDeleteBonoAplicadoException() throws Exception {
        doThrow(IllegalStateException.class).when(bonoAplicadoRepository).deleteById(1L);

        boolean response=bonoAplicadoService.deleteBonoAplicado(1L);

    }
}
