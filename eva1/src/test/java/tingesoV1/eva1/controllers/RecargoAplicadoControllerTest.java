package tingesoV1.eva1.controllers;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tingesoV1.eva1.entities.RecargoAplicadoEntity;
import tingesoV1.eva1.services.RecargoAplicadoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecargoAplicadoController.class)
public class RecargoAplicadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecargoAplicadoService recargoAplicadoService;


    @Test
    public void listRecargoAplicados_ShouldReturnRecargoAplicados() throws Exception {

        RecargoAplicadoEntity recargoAplicadoTest=new RecargoAplicadoEntity();

        recargoAplicadoTest.setId(1L);
        recargoAplicadoTest.setTipoDeRecargo("RECARGO POR ATRASO");
        recargoAplicadoTest.setPorcentajeRecargo(15);

        RecargoAplicadoEntity recargoAplicadoTest2=new RecargoAplicadoEntity();

        recargoAplicadoTest2.setId(2L);
        recargoAplicadoTest2.setTipoDeRecargo("RECARGO POR ANTIGUEADAD");
        recargoAplicadoTest2.setPorcentajeRecargo(20);


        List<RecargoAplicadoEntity> recargoAplicadoList = new ArrayList<>(Arrays.asList(recargoAplicadoTest, recargoAplicadoTest2));

        given(recargoAplicadoService.getRecargosAplicados()).willReturn((ArrayList<RecargoAplicadoEntity>) recargoAplicadoList);

        mockMvc.perform(get("/api/v1/recargoAplicado/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].porcentajeRecargo", is(15)))
                .andExpect(jsonPath("$[1].porcentajeRecargo", is(20)));
    }


    @Test
    public void saveRecargoAplicado_ShouldReturnSavedRecargoAplicado() throws Exception {
        //RecargoAplicadoEntity RecargoAplicadoToSave = new RecargoAplicadoEntity(null, "12345678-9", "New RecargoAplicado", 40000, 0, "B");
        RecargoAplicadoEntity updatedRecargoAplicado = new RecargoAplicadoEntity();

        updatedRecargoAplicado.setId(1L);
        updatedRecargoAplicado.setTipoDeRecargo("RECARGO POR ATRASO");
        updatedRecargoAplicado.setPorcentajeRecargo(15);



        given(recargoAplicadoService.saveRecargoAplicado(Mockito.any(RecargoAplicadoEntity.class))).willReturn(updatedRecargoAplicado);

        String RecargoAplicadoJson = """
                {
                  "tipoDeRecargo": "RECARGO POR ATRASO",
                  "porcentajeRecargo": 15
                }
            """;

        mockMvc.perform(post("/api/v1/recargoAplicado/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RecargoAplicadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.porcentajeRecargo", is(15)));
    }


    @Test
    public void updateRecargoAplicado_ShouldReturnUpdatedRecargoAplicado() throws Exception {
        RecargoAplicadoEntity updatedRecargoAplicado = new RecargoAplicadoEntity();

        updatedRecargoAplicado.setId(1L);
        updatedRecargoAplicado.setTipoDeRecargo("RECARGO POR ATRASO");
        updatedRecargoAplicado.setPorcentajeRecargo(15);

        given(recargoAplicadoService.updateRecargoAplicado(Mockito.any(RecargoAplicadoEntity.class))).willReturn(updatedRecargoAplicado);

        String recargoAplicadoJson = """
            {
                   "id": 1,
                   "tipoDeRecargo": "RECARGO POR ATRASO",
                  "porcentajeRecargo": 15
                
            }
            """;


        mockMvc.perform(put("/api/v1/recargoAplicado/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(recargoAplicadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.porcentajeRecargo", is(15)));
    }

    @Test
    public void deleteRecargoAplicadoById_ShouldReturn204() throws Exception {
        when(recargoAplicadoService.deleteRecargoAplicado(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/recargoAplicado/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
