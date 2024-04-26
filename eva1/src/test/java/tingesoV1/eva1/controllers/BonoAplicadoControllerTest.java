package tingesoV1.eva1.controllers;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tingesoV1.eva1.entities.BonoAplicadoEntity;
import tingesoV1.eva1.services.BonoAplicadoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BonoAplicadoController.class)
public class BonoAplicadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BonoAplicadoService bonoAplicadoService;


    @Test
    public void listBonoAplicados_ShouldReturnBonoAplicados() throws Exception {

        BonoAplicadoEntity bonoAplicadoTest=new BonoAplicadoEntity();

        bonoAplicadoTest.setId(1L);
        bonoAplicadoTest.setMonto(20000);
        bonoAplicadoTest.setIdIngreso(1);

        BonoAplicadoEntity bonoAplicadoTest2=new BonoAplicadoEntity();
        bonoAplicadoTest2.setId(2L);
        bonoAplicadoTest2.setMonto(40000);
        bonoAplicadoTest2.setIdIngreso(2);


        List<BonoAplicadoEntity> bonoAplicadoList = new ArrayList<>(Arrays.asList(bonoAplicadoTest, bonoAplicadoTest2));

        given(bonoAplicadoService.getBonosAplicados()).willReturn((ArrayList<BonoAplicadoEntity>) bonoAplicadoList);

        mockMvc.perform(get("/api/v1/bonoAplicado/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].monto", is(20000)))
                .andExpect(jsonPath("$[1].monto", is(40000)));
    }


    @Test
    public void saveBonoAplicado_ShouldReturnSavedBonoAplicado() throws Exception {
        //BonoAplicadoEntity BonoAplicadoToSave = new BonoAplicadoEntity(null, "12345678-9", "New BonoAplicado", 40000, 0, "B");
        BonoAplicadoEntity savedBonoAplicado = new BonoAplicadoEntity();


        savedBonoAplicado.setId(1L);

        savedBonoAplicado.setId(1L);
        savedBonoAplicado.setMonto(20000);
        savedBonoAplicado.setIdIngreso(1);


        given(bonoAplicadoService.saveBonoAplicado(Mockito.any(BonoAplicadoEntity.class))).willReturn(savedBonoAplicado);

        String BonoAplicadoJson = """
                {
                       "monto": 20000,
                       "idIngreso": 1     
                }
            """;

        mockMvc.perform(post("/api/v1/bonoAplicado/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(BonoAplicadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.monto", is(20000)));
    }


    @Test
    public void updateBonoAplicado_ShouldReturnUpdatedBonoAplicado() throws Exception {
        BonoAplicadoEntity updatedBonoAplicado = new BonoAplicadoEntity();

        updatedBonoAplicado.setId(1L);
        updatedBonoAplicado.setIdIngreso(1968);
        updatedBonoAplicado.setMonto(263263);


        given(bonoAplicadoService.updateBonoAplicado(Mockito.any(BonoAplicadoEntity.class))).willReturn(updatedBonoAplicado);

        String bonoAplicadoJson = """
            {
                   "id": 1,
                   "monto": 263263,
                   "idIngreso": 1968 
                
            }
            """;


        mockMvc.perform(put("/api/v1/bonoAplicado/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bonoAplicadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.monto", is(263263)));
    }

    @Test
    public void deleteBonoAplicadoById_ShouldReturn204() throws Exception {
        when(bonoAplicadoService.deleteBonoAplicado(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/bonoAplicado/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
