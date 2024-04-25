package tingesoV1.eva1.controllers;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;
import tingesoV1.eva1.services.RecargoPorKilometrajeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecargoPorKilometrajeController.class)
public class RecargoPorKilometrajeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecargoPorKilometrajeService recargoPorKilometrajeService;


    @Test
    public void listRecargoPorKilometrajes_ShouldReturnRecargoPorKilometrajes() throws Exception {

        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=new RecargoPorKilometrajeEntity();

        recargoPorKilometrajeTest.setId(1L);
        recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest.setTipoDeVehiculo("SEDAN");

        RecargoPorKilometrajeEntity recargoPorKilometrajeTest2=new RecargoPorKilometrajeEntity();

        recargoPorKilometrajeTest2.setId(2L);
        recargoPorKilometrajeTest2.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest2.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest2.setTipoDeVehiculo("PICKUP");

        ArrayList<RecargoPorKilometrajeEntity> recargoPorKilometrajeList = new ArrayList<>(Arrays.asList(recargoPorKilometrajeTest, recargoPorKilometrajeTest2));

        given(recargoPorKilometrajeService.getRecargosPorKilometraje()).willReturn(recargoPorKilometrajeList);

        mockMvc.perform(get("/api/v1/recargoPorKilometraje/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].tipoDeVehiculo", is("SEDAN")))
                .andExpect(jsonPath("$[1].tipoDeVehiculo", is("PICKUP")));
    }


    @Test
    public void saveRecargoPorKilometraje_ShouldReturnSavedRecargoPorKilometraje() throws Exception {
        //RecargoPorKilometrajeEntity RecargoPorKilometrajeToSave = new RecargoPorKilometrajeEntity(null, "12345678-9", "New RecargoPorKilometraje", 40000, 0, "B");

        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=new RecargoPorKilometrajeEntity();

        recargoPorKilometrajeTest.setId(1L);
        recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest.setTipoDeVehiculo("SEDAN");


        given(recargoPorKilometrajeService.saveRecargoPorKilometraje(Mockito.any(RecargoPorKilometrajeEntity.class))).
                willReturn(recargoPorKilometrajeTest);

        String RecargoPorKilometrajeJson = """
               {
              
                     "kilometraje": "12.001-15.000",
                     "porcentajeRecargo": 15,
                     "tipoDeVehiculo": "SEDAN"
                   }
            """;

        mockMvc.perform(post("/api/v1/recargoPorKilometraje/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RecargoPorKilometrajeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.porcentajeRecargo", is(15)));
    }


    @Test
    public void updateRecargoPorKilometraje_ShouldReturnUpdatedRecargoPorKilometraje() throws Exception {
        RecargoPorKilometrajeEntity updatedRecargoPorKilometraje = new RecargoPorKilometrajeEntity();


        updatedRecargoPorKilometraje.setId(1L);
        updatedRecargoPorKilometraje.setKilometraje("12.001-15.000");
        updatedRecargoPorKilometraje.setPorcentajeRecargo(15);
        updatedRecargoPorKilometraje.setTipoDeVehiculo("SEDAN");

        given(recargoPorKilometrajeService.updateRecargoPorKilometraje(Mockito.any(RecargoPorKilometrajeEntity.class))).
                willReturn(updatedRecargoPorKilometraje);

        String recargoPorKilometrajeJson = """
            {
                  
                     "id": 1,
                     "kilometraje": "12.001-15.000",
                     "porcentajeRecargo": 15,
                     "tipoDeVehiculo": "SEDAN"
                
            }
            """;


        mockMvc.perform(put("/api/v1/recargoPorKilometraje/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(recargoPorKilometrajeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoDeVehiculo", is("SEDAN")));
    }

    @Test
    public void deleteRecargoPorKilometrajeById_ShouldReturn204() throws Exception {
        when(recargoPorKilometrajeService.deleteRecargoPorKilometraje(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/recargoPorKilometraje/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
