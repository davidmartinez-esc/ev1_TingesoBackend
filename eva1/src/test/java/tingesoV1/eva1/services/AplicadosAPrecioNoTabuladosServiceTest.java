package tingesoV1.eva1.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tingesoV1.eva1.entities.VehiculoEntity;
import tingesoV1.eva1.repositories.BonoAplicadoRepository;
import tingesoV1.eva1.repositories.VehiculoRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class AplicadosAPrecioNoTabuladosServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private BonoAplicadoRepository bonoAplicadoRepository;

    @InjectMocks
    private AplicadosAPrecioNoTabuladosService apAPrecioNoTabuladosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenViewDisponibilityOfDiscount_thenCorrect(){
        Date fechaEjemplo=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 5, 6);

        fechaEjemplo=calendar.getTime();

        LocalTime horaEjemplo=LocalTime.parse("09:12");


        Boolean response=apAPrecioNoTabuladosService.disponibilidadDescuentoPorHoraIngreso(horaEjemplo,fechaEjemplo);
        assertEquals(true,response);

    }

    @Test
    public void whenGetRecargoPorAtrasi_thenCorrect(){

    }

    @Test
    public void whenGetBono_thenCorrect() throws Exception {

    }
}
