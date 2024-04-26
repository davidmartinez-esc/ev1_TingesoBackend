package com.example.demo.controllers;


import com.example.demo.entities.PrecioPorRepEntity;
import com.example.demo.services.PrecioPorRepService;
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

@WebMvcTest(PrecioPorRepController.class)
public class PrecioPorRepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrecioPorRepService precioPorRepService;


    @Test
    public void listPrecioPorReps_ShouldReturnPreciosPorReps() throws Exception {

        PrecioPorRepEntity precioPorRepTest=new PrecioPorRepEntity();

        precioPorRepTest.setId(1L);
        precioPorRepTest.setPrecioGasolina(196800);
        precioPorRepTest.setPrecioHibrido(120000);
        precioPorRepTest.setPrecioElectrico(200000);
        precioPorRepTest.setPrecioDiesel(220000);
        precioPorRepTest.setNombreDeLaRep("REP ELECTRICA");


        PrecioPorRepEntity precioPorRepTest2=new PrecioPorRepEntity();
        precioPorRepTest2.setId(1L);
        precioPorRepTest2.setPrecioGasolina(100800);
        precioPorRepTest2.setPrecioHibrido(121000);
        precioPorRepTest2.setPrecioElectrico(220000);
        precioPorRepTest2.setPrecioDiesel(221000);
        precioPorRepTest2.setNombreDeLaRep("REP AIRE ACONDICIONADO Y CALEFACCION");


        List<PrecioPorRepEntity> precioPorRepList = new ArrayList<>(Arrays.asList(precioPorRepTest, precioPorRepTest2));

        given(precioPorRepService.getAllPrecios()).willReturn((ArrayList<PrecioPorRepEntity>) precioPorRepList);

        mockMvc.perform(get("/api/v1/precioPorRep/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombreDeLaRep", is("REP ELECTRICA")))
                .andExpect(jsonPath("$[1].nombreDeLaRep", is("REP AIRE ACONDICIONADO Y CALEFACCION")));
    }


    @Test
    public void savePrecioPorRep_ShouldReturnSavedPrecioPorRep() throws Exception {
        //PrecioPorRepEntity PrecioPorRepToSave = new PrecioPorRepEntity(null, "12345678-9", "New PrecioPorRep", 40000, 0, "B");
        PrecioPorRepEntity precioPorRepTest=new PrecioPorRepEntity();

        precioPorRepTest.setId(1L);
        precioPorRepTest.setPrecioGasolina(196800);
        precioPorRepTest.setPrecioHibrido(120000);
        precioPorRepTest.setPrecioElectrico(200000);
        precioPorRepTest.setPrecioDiesel(220000);
        precioPorRepTest.setNombreDeLaRep("REP ELECTRICA");


        given(precioPorRepService.savePrecio(Mockito.any(PrecioPorRepEntity.class))).willReturn(precioPorRepTest);

        String PrecioPorRepJson = """
                    {
                      "precioGasolina": 196800,
                      "precioHibrido": 120000,
                      "precioElectrico": 200000,
                      "precioDiesel": 220000,
                      "nombreDeLaRep": "REP ELECTRICA"
                    }
            """;

        mockMvc.perform(post("/api/v1/precioPorRep/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PrecioPorRepJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precioDiesel", is(220000)));
    }


    @Test
    public void updatePrecioPorRep_ShouldReturnUpdatedPrecioPorRep() throws Exception {
        PrecioPorRepEntity updatedPrecioPorRep = new PrecioPorRepEntity();

        updatedPrecioPorRep.setId(1L);
        updatedPrecioPorRep.setPrecioGasolina(196800);
        updatedPrecioPorRep.setPrecioHibrido(120000);
        updatedPrecioPorRep.setPrecioElectrico(200000);
        updatedPrecioPorRep.setPrecioDiesel(220000);
        updatedPrecioPorRep.setNombreDeLaRep("REP ELECTRICA");

        given(precioPorRepService.updatePrecioPorRep(Mockito.any(PrecioPorRepEntity.class))).willReturn(updatedPrecioPorRep);

        String precioPorRepJson = """
            {
                      "id":1,
                      "precioGasolina": 196800,
                      "precioHibrido": 120000,
                      "precioElectrico": 200000,
                      "precioDiesel": 220000,
                      "nombreDeLaRep": "REP ELECTRICA"
                    }
            """;


        mockMvc.perform(put("/api/v1/precioPorRep/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(precioPorRepJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precioHibrido", is(120000)));
    }

    @Test
    public void deletePrecioPorRepById_ShouldReturn204() throws Exception {
        when(precioPorRepService.deletePrecioPorRep(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/precioPorRep/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
