package com.example.demo.services;

import com.example.demo.entities.RecargoPorAntiguedadEntity;
import com.example.demo.entities.VehiculoEntity;
import com.example.demo.repositories.RecargoPorAntiguedadRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class RecargoPorAntiguedadServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private RecargoPorAntiguedadRepository recargoPorAntiguedadRepository;

    @InjectMocks
    private RecargoPorAntiguedadService recargoPorAntiguedadService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetRecargoPorAntiguedad_thenCorrect(){

        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=
                new RecargoPorAntiguedadEntity(1L,"0-5","SEDAN",15);


        RecargoPorAntiguedadEntity recargoPorAntiguedadTest2=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest2.setId(2L);
        recargoPorAntiguedadTest2.setAntiguedad("0-5");
        recargoPorAntiguedadTest2.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest2.setTipoDeVehiculo("HATCHBACK");

        ArrayList<RecargoPorAntiguedadEntity> recargoPorAntiguedadsLista=new ArrayList<>();

        recargoPorAntiguedadsLista.add(recargoPorAntiguedadTest);
        recargoPorAntiguedadsLista.add(recargoPorAntiguedadTest2);

        when(recargoPorAntiguedadRepository.findAll()).thenReturn(recargoPorAntiguedadsLista);

        ArrayList<RecargoPorAntiguedadEntity> resultado = recargoPorAntiguedadService.getRecargosPorAntiguedad();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveRecargoPorAntiguedad_thenCorrect(){
        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("0-5");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorAntiguedadRepository.save(recargoPorAntiguedadTest)).thenReturn(recargoPorAntiguedadTest);

        RecargoPorAntiguedadEntity recargoPorAntiguedadResponse=recargoPorAntiguedadService.saveRecargoPorAntiguedad(recargoPorAntiguedadTest);

        assertEquals(recargoPorAntiguedadResponse,recargoPorAntiguedadTest);
    }

    @Test
    public void whenUpdateRecargoPorAntiguedad_thenCorrect(){
        RecargoPorAntiguedadEntity recargoPorAntiguedadTest=new RecargoPorAntiguedadEntity();

        recargoPorAntiguedadTest.setId(1L);
        recargoPorAntiguedadTest.setAntiguedad("0-5");
        recargoPorAntiguedadTest.setPorcentajeRecargo(15);
        recargoPorAntiguedadTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorAntiguedadRepository.save(recargoPorAntiguedadTest)).thenReturn(recargoPorAntiguedadTest);

        RecargoPorAntiguedadEntity recargoPorAntiguedadUpdated=recargoPorAntiguedadService.updateRecargoPorAntiguedad(recargoPorAntiguedadTest);

        assertEquals(recargoPorAntiguedadUpdated,recargoPorAntiguedadTest);
    }

    @Test
    public void testDeleteRecargoPorAntiguedad() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = recargoPorAntiguedadService.deleteRecargoPorAntiguedad(id);
        // Assert
        assertTrue(result);
        verify(recargoPorAntiguedadRepository, times(1)).deleteById(id);
    }

    @Test(expected= Exception.class)
    public void testDeleteVehiculoException() throws Exception {
        doThrow(IllegalStateException.class).when(recargoPorAntiguedadRepository).deleteById(1L);

        boolean response=recargoPorAntiguedadService.deleteRecargoPorAntiguedad(1L);

    }

    @Test
    public void testGetRecargoPorAntiguedadByTipo(){
        int anioFabricacion=1960;

        VehiculoEntity vehiculoPrueba=new VehiculoEntity();

        vehiculoPrueba.setAnio_Fabricacion(anioFabricacion);
        vehiculoPrueba.setTipo("PICKUP");

        when(recargoPorAntiguedadRepository.getRecargoByAntiguedadPorTipo("16-MAS","PICKUP")).thenReturn(20);

        Integer objetoRespuesta=recargoPorAntiguedadService.getRecargoPorAntiguedadPorTipo(vehiculoPrueba);
        int respuesta2=objetoRespuesta;

        assertEquals(20,respuesta2);

    }

    @Test
    public void testGetRecargoPorAntiguedadByTipoCon1_AnioAntiguedad(){
        int anioFabricacion=2023;

        VehiculoEntity vehiculoPrueba=new VehiculoEntity();

        vehiculoPrueba.setAnio_Fabricacion(anioFabricacion);
        vehiculoPrueba.setTipo("PICKUP");

        when(recargoPorAntiguedadRepository.getRecargoByAntiguedadPorTipo("0-5","PICKUP")).thenReturn(0);

        Integer objetoRespuesta=recargoPorAntiguedadService.getRecargoPorAntiguedadPorTipo(vehiculoPrueba);
        int respuesta2=objetoRespuesta;

        assertEquals(0,respuesta2);

    }



    @Test
    public void testGetRecargoPorAntiguedadByTipoCon6_AniosAntiguedad(){
        int anioFabricacion=2018;

        VehiculoEntity vehiculoPrueba=new VehiculoEntity();

        vehiculoPrueba.setAnio_Fabricacion(anioFabricacion);
        vehiculoPrueba.setTipo("PICKUP");

        when(recargoPorAntiguedadRepository.getRecargoByAntiguedadPorTipo("6-10","PICKUP")).thenReturn(7);

        Integer objetoRespuesta=recargoPorAntiguedadService.getRecargoPorAntiguedadPorTipo(vehiculoPrueba);
        int respuesta2=objetoRespuesta;

        assertEquals(7,respuesta2);


    }

    @Test
    public void testGetRecargoPorAntiguedadByTipoCon12_AniosAntiguedad(){
        int anioFabricacion=2012;

        VehiculoEntity vehiculoPrueba=new VehiculoEntity();

        vehiculoPrueba.setAnio_Fabricacion(anioFabricacion);
        vehiculoPrueba.setTipo("PICKUP");

        when(recargoPorAntiguedadRepository.getRecargoByAntiguedadPorTipo("11-15","PICKUP")).thenReturn(11);

        Integer objetoRespuesta=recargoPorAntiguedadService.getRecargoPorAntiguedadPorTipo(vehiculoPrueba);
        int respuesta2=objetoRespuesta;

        assertEquals(11,respuesta2);


    }

}

