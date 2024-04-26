package com.example.demo.services;

import com.example.demo.entities.RecargoPorKilometrajeEntity;
import com.example.demo.entities.VehiculoEntity;
import com.example.demo.repositories.RecargoPorKilometrajeRepository;
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


public class RecargoPorKilometrajeServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private RecargoPorKilometrajeRepository recargoPorKilometrajeRepository;

    @InjectMocks
    private RecargoPorKilometrajeService recargoPorKilometrajeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     public void whenGetRecargoPorKilometraje_thenCorrect(){

        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=
                new RecargoPorKilometrajeEntity(1L,"12.001-15.000","SEDAN",15);




        RecargoPorKilometrajeEntity recargoPorKilometrajeTest2=new RecargoPorKilometrajeEntity();
        recargoPorKilometrajeTest2.setId(2L);
        recargoPorKilometrajeTest2.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest2.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest2.setTipoDeVehiculo("PICKUP");

        ArrayList<RecargoPorKilometrajeEntity> recargoPorKilometrajesLista=new ArrayList<>();

        recargoPorKilometrajesLista.add(recargoPorKilometrajeTest);
        recargoPorKilometrajesLista.add(recargoPorKilometrajeTest2);

        when(recargoPorKilometrajeRepository.findAll()).thenReturn(recargoPorKilometrajesLista);

        ArrayList<RecargoPorKilometrajeEntity> resultado = recargoPorKilometrajeService.getRecargosPorKilometraje();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveRecargoPorKilometraje_thenCorrect(){
        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=new RecargoPorKilometrajeEntity();

        recargoPorKilometrajeTest.setId(1L);
        recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorKilometrajeRepository.save(recargoPorKilometrajeTest)).thenReturn(recargoPorKilometrajeTest);

        RecargoPorKilometrajeEntity recargoPorKilometrajeResponse=
                recargoPorKilometrajeService.saveRecargoPorKilometraje(recargoPorKilometrajeTest);

        assertEquals(recargoPorKilometrajeResponse,recargoPorKilometrajeTest);
    }

    @Test
    public void whenUpdateRecargoPorKilometraje_thenCorrect(){
        RecargoPorKilometrajeEntity recargoPorKilometrajeTest=new RecargoPorKilometrajeEntity();

        recargoPorKilometrajeTest.setId(1L);
        recargoPorKilometrajeTest.setKilometraje("12.001-15.000");
        recargoPorKilometrajeTest.setPorcentajeRecargo(15);
        recargoPorKilometrajeTest.setTipoDeVehiculo("SEDAN");

        when(recargoPorKilometrajeRepository.save(recargoPorKilometrajeTest)).thenReturn(recargoPorKilometrajeTest);

        RecargoPorKilometrajeEntity recargoPorKilometrajeUpdated=recargoPorKilometrajeService.updateRecargoPorKilometraje(recargoPorKilometrajeTest);

        assertEquals(recargoPorKilometrajeUpdated,recargoPorKilometrajeTest);
    }

    @Test
    public void testDeleteRecargoPorKilometraje() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = recargoPorKilometrajeService.deleteRecargoPorKilometraje(id);
        // Assert
        assertTrue(result);
        verify(recargoPorKilometrajeRepository, times(1)).deleteById(id);
    }

    @Test(expected= Exception.class)
    public void testDeleteRecargoPorKlometrajeException() throws Exception {
        doThrow(IllegalStateException.class).when(recargoPorKilometrajeRepository).deleteById(1L);

        boolean response=recargoPorKilometrajeService.deleteRecargoPorKilometraje(1L);

    }

    @Test
    public void whenGetRecargoKilometraje5000km_thenCorrect(){
        VehiculoEntity vehiculoTest=new VehiculoEntity();


        vehiculoTest.setAnio_Fabricacion(1968);
        vehiculoTest.setPatente("ABC123");
        vehiculoTest.setMarca("TOYOTA");
        vehiculoTest.setModelo("COROLLA");
        vehiculoTest.setTipo("SEDAN");
        vehiculoTest.setTipoMotor("GASOLINA");
        vehiculoTest.setNumeroDeAsientos(5);

        when(recargoPorKilometrajeRepository.
                getRecargoByKilmetrajeYTipoDeVehiculo("5.001-12.000","SEDAN")).thenReturn(3);

        Integer respuesta=
                recargoPorKilometrajeService.getRecargoPorAntiguedadByTipoDeVehiculo(6000,vehiculoTest);

        int repuestaParsed= respuesta;
        assertEquals(Integer.valueOf(3),respuesta);
    }

    @Test
    public void whenGetRecargoKilometraje20000km_thenCorrect(){
        VehiculoEntity vehiculoTest=new VehiculoEntity();


        vehiculoTest.setAnio_Fabricacion(1968);
        vehiculoTest.setPatente("ABC123");
        vehiculoTest.setMarca("TOYOTA");
        vehiculoTest.setModelo("COROLLA");
        vehiculoTest.setTipo("SEDAN");
        vehiculoTest.setTipoMotor("GASOLINA");
        vehiculoTest.setNumeroDeAsientos(5);

        when(recargoPorKilometrajeRepository.
                getRecargoByKilmetrajeYTipoDeVehiculo("12.001-25.000","SEDAN")).thenReturn(7);

        Integer respuesta=
                recargoPorKilometrajeService.getRecargoPorAntiguedadByTipoDeVehiculo(20000,vehiculoTest);

        int repuestaParsed= respuesta;
        assertEquals(Integer.valueOf(7),respuesta);
    }
}
