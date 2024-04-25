package tingesoV1.eva1.controllers;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tingesoV1.eva1.entities.DescuentoPorNRepEntity;
import tingesoV1.eva1.services.DescuentoPorNRepService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DescuentoPorNRepController.class)
public class DescuentoPorNRepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DescuentoPorNRepService descuentoPorNRepService;


    @Test
    public void listDescuentoPorNReps_ShouldReturnDescuentoPorNReps() throws Exception {

        DescuentoPorNRepEntity descuentoPorNRepTest=new DescuentoPorNRepEntity();

        descuentoPorNRepTest.setId(1L);
        descuentoPorNRepTest.setNumeroDeReparaciones("16-MAS");
        descuentoPorNRepTest.setTipoDeMotor("HIBRIDO");
        descuentoPorNRepTest.setPorcentajeDescuento(20);

        DescuentoPorNRepEntity descuentoPorNRepTest2=new DescuentoPorNRepEntity();
        descuentoPorNRepTest2.setId(2L);
        descuentoPorNRepTest2.setNumeroDeReparaciones("16-MAS");
        descuentoPorNRepTest2.setTipoDeMotor("ELECTRICO");
        descuentoPorNRepTest2.setPorcentajeDescuento(10);


        List<DescuentoPorNRepEntity> descuentoPorNRepList = new ArrayList<>(Arrays.asList(descuentoPorNRepTest, descuentoPorNRepTest2));

        given(descuentoPorNRepService.getDescuentoPorNReps()).willReturn((ArrayList<DescuentoPorNRepEntity>) descuentoPorNRepList);

        mockMvc.perform(get("/api/v1/descuentosPorNRep/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].tipoDeMotor", is("HIBRIDO")))
                .andExpect(jsonPath("$[1].tipoDeMotor", is("ELECTRICO")));
    }


    @Test
    public void saveDescuentoPorNRep_ShouldReturnSavedDescuentoPorNRep() throws Exception {
        //DescuentoPorNRepEntity DescuentoPorNRepToSave = new DescuentoPorNRepEntity(null, "12345678-9", "New DescuentoPorNRep", 40000, 0, "B");
        DescuentoPorNRepEntity descuentoPorNRepTest=new DescuentoPorNRepEntity();

        descuentoPorNRepTest.setId(1L);
        descuentoPorNRepTest.setNumeroDeReparaciones("16-MAS");
        descuentoPorNRepTest.setTipoDeMotor("HIBRIDO");
        descuentoPorNRepTest.setPorcentajeDescuento(20);

        given(descuentoPorNRepService.
                saveDescuentoPorNRep(Mockito.any(DescuentoPorNRepEntity.class))).willReturn(descuentoPorNRepTest);

        String DescuentoPorNRepJson = """
                {
                      "numeroDeReparaciones": "16-MAS",
                      "tipoDeMotor": "HIBRIDO",
                      "porcentajeDescuento": 20
                    }
            """;

        mockMvc.perform(post("/api/v1/descuentosPorNRep/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DescuentoPorNRepJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.porcentajeDescuento", is(20)));
    }


    @Test
    public void updateDescuentoPorNRep_ShouldReturnUpdatedDescuentoPorNRep() throws Exception {
        DescuentoPorNRepEntity descuentoPorNRepTest=new DescuentoPorNRepEntity();

        descuentoPorNRepTest.setId(1L);
        descuentoPorNRepTest.setNumeroDeReparaciones("16-MAS");
        descuentoPorNRepTest.setTipoDeMotor("HIBRIDO");
        descuentoPorNRepTest.setPorcentajeDescuento(20);

        given(descuentoPorNRepService.
                updateDescuentoPorNRep(Mockito.any(DescuentoPorNRepEntity.class))).willReturn(descuentoPorNRepTest);

        String descuentoPorNRepJson = """
             {
                       "id":1,
                      "numeroDeReparaciones": "16-MAS",
                      "tipoDeMotor": "HIBRIDO",
                      "porcentajeDescuento": 20
                    }
            """;


        mockMvc.perform(put("/api/v1/descuentosPorNRep/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(descuentoPorNRepJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroDeReparaciones", is("16-MAS")));
    }

    @Test
    public void deleteDescuentoPorNRepById_ShouldReturn204() throws Exception {
        when(descuentoPorNRepService.deleteDescuentoPorNRep(1L)).thenReturn(true); // Assuming the method returns a boolean

        mockMvc.perform(delete("/api/v1/descuentosPorNRep/{id}", 1L))
                .andExpect(status().isNoContent());
    }




}
