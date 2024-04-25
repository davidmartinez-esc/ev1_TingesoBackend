package tingesoV1.eva1.controllers;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.services.RecargoPorAntiguedadService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecargoPorAntiguedadController.class)
public class RecargoPorAntiguedadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecargoPorAntiguedadService recargoPorAntiguedadService;


    @Test
    public void listRecargoPorAntiguedads_ShouldReturnRecargoPorAntiguedads() throws Exception {

        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("12.001-15.000");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("SEDAN");

        RecargoPorAntiguedadEntity recargoPorAntiguedadTest2=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest2.setId(2L);
        recargoPorAntiguedadTest2.setAntiguedad("12.001-15.000");
        recargoPorAntiguedadTest2.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest2.setTipoDeVehiculo("PICKUP");

        ArrayList<RecargoPorAntiguedadEntity> recargoPorAntiguedadList = new ArrayList<>(Arrays.asList(recargoPorAntiguedadTest, recargoPorAntiguedadTest2));

        given(recargoPorAntiguedadService.getRecargosPorAntiguedad()).willReturn(recargoPorAntiguedadList);

        mockMvc.perform(get("/api/v1/recargoPorAntiguedad/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].tipoDeVehiculo", is("SEDAN")))
                .andExpect(jsonPath("$[1].tipoDeVehiculo", is("PICKUP")));
    }


    @Test
    public void saveRecargoPorAntiguedad_ShouldReturnSavedRecargoPorAntiguedad() throws Exception {
        //RecargoPorAntiguedadEntity RecargoPorAntiguedadToSave = new RecargoPorAntiguedadEntity(null, "12345678-9", "New RecargoPorAntiguedad", 40000, 0, "B");

        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("12.001-15.000");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("SEDAN");


        given(recargoPorAntiguedadService.saveRecargoPorAntiguedad(Mockito.any(RecargoPorAntiguedadEntity.class))).
                willReturn(recargoPorAntiguedadTest);

        String RecargoPorAntiguedadJson = """
               {
              
                     "antiguedad": "12.001-15.000",
                     "porcentajeRecargo": 15,
                     "tipoDeVehiculo": "SEDAN"
                   }
            """;

        mockMvc.perform(post("/api/v1/recargoPorAntiguedad/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RecargoPorAntiguedadJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.porcentajeRecargo", is(15)));
    }


    @Test
    public void updateRecargoPorAntiguedad_ShouldReturnUpdatedRecargoPorAntiguedad() throws Exception {
        RecargoPorAntiguedadEntity updatedRecargoPorAntiguedad = new RecargoPorAntiguedadEntity();


        updatedRecargoPorAntiguedad.setId(1L);
        updatedRecargoPorAntiguedad.setAntiguedad("12.001-15.000");
        updatedRecargoPorAntiguedad.setPorcentajeRecargo(15);
        updatedRecargoPorAntiguedad.setTipoDeVehiculo("SEDAN");

        given(recargoPorAntiguedadService.updateRecargoPorAntiguedad(Mockito.any(RecargoPorAntiguedadEntity.class))).
                willReturn(updatedRecargoPorAntiguedad);

        String recargoPorAntiguedadJson = """
            {
                  
                     "id": 1,
                     "antiguedad": "12.001-15.000",
                     "porcentajeRecargo": 15,
                     "tipoDeVehiculo": "SEDAN"
                
            }
            """;


        mockMvc.perform(put("/api/v1/recargoPorAntiguedad/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(recargoPorAntiguedadJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoDeVehiculo", is("SEDAN")));
    }

    @Test
    public void deleteRecargoPorAntiguedadById_ShouldReturn204() throws Exception {
        when(recargoPorAntiguedadService.deleteRecargoPorAntiguedad(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/recargoPorAntiguedad/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
