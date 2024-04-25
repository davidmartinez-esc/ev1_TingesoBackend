package tingesoV1.eva1.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tingesoV1.eva1.entities.RecargoAplicadoEntity;
import tingesoV1.eva1.repositories.RecargoAplicadoRepository;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class RecargoAplicadoServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private RecargoAplicadoRepository recargoAplicadoRepository;

    @InjectMocks
    private RecargoAplicadoService recargoAplicadoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetRecargoAplicado_thenCorrect(){

        RecargoAplicadoEntity recargoAplicadoTest=new RecargoAplicadoEntity();

        recargoAplicadoTest.setId(1l);
        recargoAplicadoTest.setPorcentajeRecargo(15);
        recargoAplicadoTest.setTipoDeRecargo("RECARGO POR ANTIGUEDAD");
        recargoAplicadoTest.setIdIngreso(1);

        RecargoAplicadoEntity recargoAplicadoTest2=new RecargoAplicadoEntity();

        recargoAplicadoTest2.setId(2l);
        recargoAplicadoTest2.setPorcentajeRecargo(15);
        recargoAplicadoTest2.setTipoDeRecargo("RECARGO POR ATRASO");
        recargoAplicadoTest2.setIdIngreso(1);

        ArrayList<RecargoAplicadoEntity> recargosAplicadosLista=new ArrayList<>();

        recargosAplicadosLista.add(recargoAplicadoTest);
        recargosAplicadosLista.add(recargoAplicadoTest2);

        when(recargoAplicadoRepository.findAll()).thenReturn(recargosAplicadosLista);

        ArrayList<RecargoAplicadoEntity> resultado = recargoAplicadoService.getRecargosAplicados();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveRecargoAplicado_thenCorrect(){
        RecargoAplicadoEntity recargoAplicadoTest=new RecargoAplicadoEntity();

        recargoAplicadoTest.setId(1l);
        recargoAplicadoTest.setPorcentajeRecargo(15);
        recargoAplicadoTest.setTipoDeRecargo("RECARGO POR ANTIGUEDAD");
        recargoAplicadoTest.setIdIngreso(1);

        when(recargoAplicadoRepository.save(recargoAplicadoTest)).thenReturn(recargoAplicadoTest);

        RecargoAplicadoEntity recargoAplicadoResponse=recargoAplicadoService.saveRecargoAplicado(recargoAplicadoTest);

        assertEquals(recargoAplicadoResponse,recargoAplicadoTest);
    }

    @Test
    public void whenUpdateRecargoAplicado_thenCorrect(){
        RecargoAplicadoEntity recargoAplicadoTest=new RecargoAplicadoEntity();

        recargoAplicadoTest.setId(1l);
        recargoAplicadoTest.setPorcentajeRecargo(15);
        recargoAplicadoTest.setTipoDeRecargo("RECARGO POR ANTIGUEDAD");
        recargoAplicadoTest.setIdIngreso(1);

        when(recargoAplicadoRepository.save(recargoAplicadoTest)).thenReturn(recargoAplicadoTest);

        RecargoAplicadoEntity recargoAplicadoUpdated=recargoAplicadoService.updateRecargoAplicado(recargoAplicadoTest);

        assertEquals(recargoAplicadoUpdated,recargoAplicadoTest);
    }

    @Test
    public void testDeleteRecargoAplicado() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = recargoAplicadoService.deleteRecargoAplicado(id);
        // Assert
        assertTrue(result);
        verify(recargoAplicadoRepository, times(1)).deleteById(id);
    }

    @Test(expected= Exception.class)
    public void testDeleterecargoAplicadoException() throws Exception {
        doThrow(IllegalStateException.class).when(recargoAplicadoRepository).deleteById(1L);

        boolean response=recargoAplicadoService.deleteRecargoAplicado(1L);

    }
}
