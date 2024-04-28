package com.example.demo.controllers;


import com.example.demo.entities.RepEspecificaEntity;
import com.example.demo.services.RepEspecificaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RepEspecificaController.class)
public class RepEspecificaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RepEspecificaService repEspecificaService;


    @Test
    public void listRepEspecificas_ShouldReturnRepEspecificas() throws Exception {

        RepEspecificaEntity repEspecificaTest=new RepEspecificaEntity();


        repEspecificaTest.setId(1L);
        repEspecificaTest.setIdIngresoARep(1);
        repEspecificaTest.setPrecioDeLaReparacion(125000);
        repEspecificaTest.setNombreDeLaRep("REP ELECTRICA");

        RepEspecificaEntity repEspecificaTest2=new RepEspecificaEntity();


        repEspecificaTest2.setId(13L);
        repEspecificaTest2.setIdIngresoARep(2);
        repEspecificaTest2.setPrecioDeLaReparacion(122000);
        repEspecificaTest2.setNombreDeLaRep("REP ELECTRICA");


        List<RepEspecificaEntity> repEspecificasList = new ArrayList<>(Arrays.asList(repEspecificaTest, repEspecificaTest2));

        given(repEspecificaService.getAllReparacionesEspecificas()).willReturn((ArrayList<RepEspecificaEntity>) repEspecificasList);

        mockMvc.perform(get("/api/v1/repEspecifica/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].precioDeLaReparacion", is(125000)))
                .andExpect(jsonPath("$[1].precioDeLaReparacion", is(122000)));
    }


    @Test
    public void saveRepEspecifica_ShouldReturnSavedRepEspecifica() throws Exception {
        //RepEspecificaEntity RepEspecificaToSave = new RepEspecificaEntity(null, "12345678-9", "New RepEspecifica", 40000, 0, "B");
        RepEspecificaEntity updatedRepEspecifica=new RepEspecificaEntity();


        updatedRepEspecifica.setId(1L);
        updatedRepEspecifica.setIdIngresoARep(1);
        updatedRepEspecifica.setPrecioDeLaReparacion(125000);
        updatedRepEspecifica.setNombreDeLaRep("REP ELECTRICA");


        given(repEspecificaService.saveTipoDeRep(Mockito.any(RepEspecificaEntity.class))).willReturn(updatedRepEspecifica);

        String RepEspecificaJson = """
                {
                  "idIngresoARep": 1,
                  "precioDeLaReparacion": 125000,
                  "nombreDeLaRep": "REP ELECTRICA"
                }
            """;

        mockMvc.perform(post("/api/v1/repEspecifica/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RepEspecificaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idIngresoARep", is(1)));
    }


    @Test
    public void updateRepEspecifica_ShouldReturnUpdatedRepEspecifica() throws Exception {
        RepEspecificaEntity updatedRepEspecifica = new RepEspecificaEntity();


        updatedRepEspecifica.setId(1L);
        updatedRepEspecifica.setIdIngresoARep(1);
        updatedRepEspecifica.setPrecioDeLaReparacion(125000);
        updatedRepEspecifica.setNombreDeLaRep("REP ELECTRICA");

        given(repEspecificaService.updateRepEspecifica(Mockito.any(RepEspecificaEntity.class))).willReturn(updatedRepEspecifica);

        String repEspecificaJson = """
             {
                  "id":1,
                  "idIngresoARep": 1,
                  "precioDeLaReparacion": 125000,
                  "nombreDeLaRep": "REP ELECTRICA"
                }
            """;


        mockMvc.perform(put("/api/v1/repEspecifica/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(repEspecificaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeLaRep", is("REP ELECTRICA")));
    }

    @Test
    public void deleteRepEspecificaById_ShouldReturn204() throws Exception {
        when(repEspecificaService.deleteRepEspecifica(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/repEspecifica/{id}", 1L))
                .andExpect(status().isNoContent());
    }


    @Test
    public void getRepEspecificasByIdIngreso_ShouldReturnRepEspecificas() throws Exception {

        RepEspecificaEntity repEspecificaTest=new RepEspecificaEntity();


        repEspecificaTest.setId(1L);
        repEspecificaTest.setIdIngresoARep(1);
        repEspecificaTest.setPrecioDeLaReparacion(125000);
        repEspecificaTest.setNombreDeLaRep("REP ELECTRICA");

        RepEspecificaEntity repEspecificaTest2=new RepEspecificaEntity();


        repEspecificaTest2.setId(2L);
        repEspecificaTest2.setIdIngresoARep(1);
        repEspecificaTest2.setPrecioDeLaReparacion(122000);
        repEspecificaTest2.setNombreDeLaRep("REP ELECTRICA");


        List<RepEspecificaEntity> repEspecificasList = new ArrayList<>(Arrays.asList(repEspecificaTest, repEspecificaTest2));

        given(repEspecificaService.getRepEspecificaByIdIngreso(1)).willReturn((ArrayList<RepEspecificaEntity>) repEspecificasList);

        mockMvc.perform(get("/api/v1/repEspecifica/getByIdIngreso/{id}",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idIngresoARep", is(1)))
                .andExpect(jsonPath("$[1].idIngresoARep", is(1)));
    }



}
