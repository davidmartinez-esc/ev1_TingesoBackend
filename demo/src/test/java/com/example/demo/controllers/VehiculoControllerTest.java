package com.example.demo.controllers;


import com.example.demo.entities.VehiculoEntity;
import com.example.demo.services.VehiculoService;
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

@WebMvcTest(VehiculoController.class)
public class VehiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehiculoService vehiculoService;


    @Test
    public void listVehiculos_ShouldReturnVehiculos() throws Exception {

        VehiculoEntity vehiculoTest=new VehiculoEntity();

        vehiculoTest.setId(1L);
        vehiculoTest.setAnio_Fabricacion(1968);
        vehiculoTest.setPatente("ABC123");
        vehiculoTest.setMarca("TOYOTA");
        vehiculoTest.setModelo("COROLLA");
        vehiculoTest.setTipo("SEDAN");
        vehiculoTest.setTipoMotor("GASOLINA");
        vehiculoTest.setNumeroDeAsientos(5);

        VehiculoEntity vehiculoTest2=new VehiculoEntity();
        vehiculoTest2.setId(2L);
        vehiculoTest2.setAnio_Fabricacion(1966);
        vehiculoTest2.setPatente("ACC123");
        vehiculoTest2.setMarca("SUZUKI");
        vehiculoTest2.setModelo("X2345");
        vehiculoTest2.setTipo("SEDAN");
        vehiculoTest2.setTipoMotor("GASOLINA");
        vehiculoTest2.setNumeroDeAsientos(5);


        List<VehiculoEntity> vehiculoList = new ArrayList<>(Arrays.asList(vehiculoTest, vehiculoTest2));

        given(vehiculoService.getVehiculos()).willReturn((ArrayList<VehiculoEntity>) vehiculoList);

        mockMvc.perform(get("/api/v1/vehiculo/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].marca", is("TOYOTA")))
                .andExpect(jsonPath("$[1].marca", is("SUZUKI")));
    }


    @Test
    public void saveVehiculo_ShouldReturnSavedVehiculo() throws Exception {
        //VehiculoEntity VehiculoToSave = new VehiculoEntity(null, "12345678-9", "New Vehiculo", 40000, 0, "B");
        VehiculoEntity updatedVehiculo = new VehiculoEntity();


        updatedVehiculo.setId(1L);
        updatedVehiculo.setAnio_Fabricacion(1968);
        updatedVehiculo.setPatente("ABC123");
        updatedVehiculo.setMarca("TOYOTA");
        updatedVehiculo.setModelo("COROLLA");
        updatedVehiculo.setTipo("SEDAN");
        updatedVehiculo.setTipoMotor("GASOLINA");
        updatedVehiculo.setNumeroDeAsientos(5);


        given(vehiculoService.saveVehiculo(Mockito.any(VehiculoEntity.class))).willReturn(updatedVehiculo);

        String VehiculoJson = """
                {
                  "anio_fabricacion": 1968,
                  "patente": "ABC123",
                  "marca": "TOYOTA",
                  "modelo": "COROLLA",
                  "tipo": "SEDAN",
                  "tipo_motor": "GASOLINA",
                  "numero_de_asientos": 5
                }
            """;

        mockMvc.perform(post("/api/v1/vehiculo/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(VehiculoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca", is("TOYOTA")));
    }


    @Test
    public void updateVehiculo_ShouldReturnUpdatedVehiculo() throws Exception {
        VehiculoEntity updatedVehiculo = new VehiculoEntity();

        updatedVehiculo.setId(1L);
        updatedVehiculo.setAnio_Fabricacion(1968);
        updatedVehiculo.setPatente("ABC123");
        updatedVehiculo.setMarca("SUZUKI");
        updatedVehiculo.setModelo("ALTO");
        updatedVehiculo.setTipo("SEDAN");
        updatedVehiculo.setTipoMotor("GASOLINA");
        updatedVehiculo.setNumeroDeAsientos(5);

        given(vehiculoService.updateVehiculo(Mockito.any(VehiculoEntity.class))).willReturn(updatedVehiculo);

        String vehiculoJson = """
            {
                   "id": 1,
                  "anio_fabricacion": 1968,
                  "patente": "ABC123",
                  "marca": "SUZUKI",
                  "modelo": "ALTO",
                  "tipo": "SEDAN",
                  "tipo_motor": "GASOLINA",
                  "numero_de_asientos": 5
                
            }
            """;


        mockMvc.perform(put("/api/v1/vehiculo/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vehiculoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo", is("ALTO")));
    }

    @Test
    public void deleteVehiculoById_ShouldReturn204() throws Exception {
        when(vehiculoService.deleteVehiculo(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/vehiculo/{id}", 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getVehiculoById_ShouldReturnVehiculo() throws Exception {
        VehiculoEntity vehiculoTest = new VehiculoEntity();

        vehiculoTest.setId(1L);
        vehiculoTest.setAnio_Fabricacion(1968);
        vehiculoTest.setPatente("ABC123");
        vehiculoTest.setMarca("TOYOTA");
        vehiculoTest.setModelo("COROLLA");
        vehiculoTest.setTipo("SEDAN");
        vehiculoTest.setTipoMotor("GASOLINA");
        vehiculoTest.setNumeroDeAsientos(5);

        given(vehiculoService.getVehiculoById(1L)).willReturn(vehiculoTest);

        mockMvc.perform(get("/api/v1/vehiculo/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patente", is("ABC123")));
    }




}
