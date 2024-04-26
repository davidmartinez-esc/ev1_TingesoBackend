package com.example.demo.controllers;


import com.example.demo.entities.IngresoARepEntity;
import com.example.demo.services.IngresoARepService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(IngresoARepController.class)
public class IngresoARepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngresoARepService ingresoARepService;


    @Test
    public void listIngresoAReps_ShouldReturnIngresoAReps() throws Exception {

        IngresoARepEntity ingresoARepTest=new IngresoARepEntity();


        ingresoARepTest.setId(1L);
        ingresoARepTest.setIdVehiculo(1);
        ingresoARepTest.setCostoTotal(75000);

        ingresoARepTest.setFechaIngreso(new Date());
        ingresoARepTest.setHoraIngreso(LocalTime.now());

        LocalDate fechaSalida = LocalDate.now().plusDays(1);
        ingresoARepTest.setFechaSalida(Date.from(fechaSalida.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        ingresoARepTest.setHoraSalida(LocalTime.of(15, 30)); // Supongamos que es a las 15:30

        LocalDate fechaRecogida = LocalDate.now().plusDays(2);
        ingresoARepTest.setFechaRecogida(Date.from(fechaRecogida.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        ingresoARepTest.setHoraRecogida(LocalTime.of(10, 0)); // Supongamos que es a las 10:00

        //INGRESO A REP 2
        IngresoARepEntity ingresoARepTest2=new IngresoARepEntity();
        ingresoARepTest2.setId(2L);

        ingresoARepTest2.setCostoTotal(150000);


        List<IngresoARepEntity> ingresoARepList = new ArrayList<>(Arrays.asList(ingresoARepTest, ingresoARepTest2));

        given(ingresoARepService.getReparaciones()).willReturn((ArrayList<IngresoARepEntity>) ingresoARepList);

        mockMvc.perform(get("/api/v1/ingresoAReparacion/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].costoTotal", is(75000)))
                .andExpect(jsonPath("$[1].costoTotal", is(150000)));
    }


    @Test
    public void saveIngresoARep_ShouldReturnSavedIngresoARep() throws Exception {
        Calendar calendario = Calendar.getInstance();
        calendario.set(1993,3,1);

        IngresoARepEntity savedIngresoARep = new IngresoARepEntity();

        savedIngresoARep.setId(1L);
        savedIngresoARep.setIdVehiculo(1);
        savedIngresoARep.setCostoTotal(75000);

        savedIngresoARep.setFechaIngreso(calendario.getTime());
        savedIngresoARep.setHoraIngreso(LocalTime.now());

        calendario.add(Calendar.DAY_OF_MONTH, 1);
        savedIngresoARep.setFechaSalida(calendario.getTime());
        savedIngresoARep.setHoraSalida(LocalTime.of(21, 21));

        calendario.add(Calendar.DAY_OF_MONTH, 1);
        savedIngresoARep.setFechaRecogida(calendario.getTime());
        savedIngresoARep.setHoraRecogida(LocalTime.of(22, 21));


        given(ingresoARepService.saveReparacion(Mockito.any(IngresoARepEntity.class))).willReturn(savedIngresoARep);

        String IngresoARepJson = """
               {
                     "costoTotal": 75000,
                     "fechaIngreso": "1993-04-01",
                     "horaIngreso": "20:00",
                     "fechaSalida": "1993-04-02",
                     "horaSalida": "21:21",
                     "fechaRecogida": "1993-04-03",
                     "horaRecogida": "22:21",
                     "idVehiculo":1
                 }
            """;

        mockMvc.perform(post("/api/v1/ingresoAReparacion/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(IngresoARepJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.costoTotal", is(75000)));
    }


    @Test
    public void updateIngresoARep_ShouldReturnUpdatedIngresoARep() throws Exception {
        Calendar calendario = Calendar.getInstance();
        calendario.set(1993,3,1);

        IngresoARepEntity updatedIngresoARep = new IngresoARepEntity();

        updatedIngresoARep.setId(1L);
        updatedIngresoARep.setIdVehiculo(1);
        updatedIngresoARep.setCostoTotal(75000);

        updatedIngresoARep.setFechaIngreso(calendario.getTime());
        updatedIngresoARep.setHoraIngreso(LocalTime.now());

        calendario.add(Calendar.DAY_OF_MONTH, 1);
        updatedIngresoARep.setFechaSalida(calendario.getTime());
        updatedIngresoARep.setHoraSalida(LocalTime.of(21, 21));

        calendario.add(Calendar.DAY_OF_MONTH, 1);
        updatedIngresoARep.setFechaRecogida(calendario.getTime());
        updatedIngresoARep.setHoraRecogida(LocalTime.of(22, 21));

        given(ingresoARepService.updateIngresoARep(Mockito.any(IngresoARepEntity.class))).willReturn(updatedIngresoARep);

        String ingresoARepJson = """
             {
                    "id":1,
                     "costoTotal": 75000,
                     "fechaIngreso": "1993-04-01",
                     "horaIngreso": "20:00",
                     "fechaSalida": "1993-04-02",
                     "horaSalida": "21:21",
                     "fechaRecogida": "1993-04-03",
                     "horaRecogida": "22:21",
                     "idVehiculo":1
                 }
            """;


        mockMvc.perform(put("/api/v1/ingresoAReparacion/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ingresoARepJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idVehiculo", is(1)));
    }

    @Test
    public void deleteIngresoARepById_ShouldReturn204() throws Exception {
        when(ingresoARepService.deleteIngresoARep(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/ingresoAReparacion/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
