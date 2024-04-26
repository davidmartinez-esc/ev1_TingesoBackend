package com.example.demo.controllers;


import com.example.demo.entities.DescuentoAplicadoEntity;
import com.example.demo.services.DescuentoAplicadoService;
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

@WebMvcTest(DescuentoAplicadoController.class)
public class DescuentoAplicadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DescuentoAplicadoService descuentoAplicadoService;


    @Test
    public void listDescuentoAplicados_ShouldReturnDescuentoAplicados() throws Exception {

        DescuentoAplicadoEntity descuentoAplicadoTest=new DescuentoAplicadoEntity();

        descuentoAplicadoTest.setId(1L);
        descuentoAplicadoTest.setTipoDeDescuento("DESCUENTO POR NUMERO DE REPARACIONES");
        descuentoAplicadoTest.setIdIngreso(1);
        descuentoAplicadoTest.setPorcentajeDescuento(20);

        DescuentoAplicadoEntity descuentoAplicadoTest2=new DescuentoAplicadoEntity();

        descuentoAplicadoTest2.setId(2L);
        descuentoAplicadoTest2.setTipoDeDescuento("DESCUENTO POR DIA LUNES-JUEVES");
        descuentoAplicadoTest2.setIdIngreso(1);
        descuentoAplicadoTest2.setPorcentajeDescuento(20);


        List<DescuentoAplicadoEntity> descuentoAplicadoList = new ArrayList<>(Arrays.asList(descuentoAplicadoTest, descuentoAplicadoTest2));

        given(descuentoAplicadoService.getDescuentosAplicados()).willReturn((ArrayList<DescuentoAplicadoEntity>) descuentoAplicadoList);

        mockMvc.perform(get("/api/v1/descuentoAplicado/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].tipoDeDescuento", is("DESCUENTO POR NUMERO DE REPARACIONES")))
                .andExpect(jsonPath("$[1].tipoDeDescuento", is("DESCUENTO POR DIA LUNES-JUEVES")));
    }


    @Test
    public void saveDescuentoAplicado_ShouldReturnSavedDescuentoAplicado() throws Exception {
        //DescuentoAplicadoEntity DescuentoAplicadoToSave = new DescuentoAplicadoEntity(null, "12345678-9", "New DescuentoAplicado", 40000, 0, "B");
        DescuentoAplicadoEntity descuentoAplicadoTest=new DescuentoAplicadoEntity();

        descuentoAplicadoTest.setId(1L);
        descuentoAplicadoTest.setTipoDeDescuento("DESCUENTO POR NUMERO DE REPARACIONES");
        descuentoAplicadoTest.setIdIngreso(1);
        descuentoAplicadoTest.setPorcentajeDescuento(20);

        given(descuentoAplicadoService.
                saveDescuentoAplicado(Mockito.any(DescuentoAplicadoEntity.class))).willReturn(descuentoAplicadoTest);

        String DescuentoAplicadoJson = """
                {
                      "id": 1,
                      "tipoDeDescuento": "DESCUENTO POR NUMERO DE REPARACIONES",
                      "idIngreso": 1,
                      "porcentajeDescuento": 20
                    }
            """;

        mockMvc.perform(post("/api/v1/descuentoAplicado/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DescuentoAplicadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.porcentajeDescuento", is(20)));
    }


    @Test
    public void updateDescuentoAplicado_ShouldReturnUpdatedDescuentoAplicado() throws Exception {
        DescuentoAplicadoEntity descuentoAplicadoTest=new DescuentoAplicadoEntity();

        descuentoAplicadoTest.setId(1L);
        descuentoAplicadoTest.setTipoDeDescuento("DESCUENTO POR NUMERO DE REPARACIONES");
        descuentoAplicadoTest.setIdIngreso(1);
        descuentoAplicadoTest.setPorcentajeDescuento(20);

        given(descuentoAplicadoService.
                updateDescuentoAplicado(Mockito.any(DescuentoAplicadoEntity.class))).willReturn(descuentoAplicadoTest);

        String descuentoAplicadoJson = """
             {
                   "id": 1,
                   "tipoDeDescuento": "DESCUENTO POR NUMERO DE REPARACIONES",
                   "idIngreso": 1,
                   "porcentajeDescuento": 20
                 }
            """;


        mockMvc.perform(put("/api/v1/descuentoAplicado/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(descuentoAplicadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoDeDescuento", is("DESCUENTO POR NUMERO DE REPARACIONES")));
    }

    @Test
    public void deleteDescuentoAplicadoById_ShouldReturn204() throws Exception {
        when(descuentoAplicadoService.deleteDescuentoAplicado(1L)).thenReturn(true);
        mockMvc.perform(delete("/api/v1/descuentoAplicado/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
