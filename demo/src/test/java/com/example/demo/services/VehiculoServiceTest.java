package com.example.demo.services;

import com.example.demo.entities.VehiculoEntity;
import com.example.demo.repositories.VehiculoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class VehiculoServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private VehiculoRepository vehiculoRepository;

    @InjectMocks
    private VehiculoService vehiculoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetVehiculo_thenCorrect(){

        VehiculoEntity vehiculoTest=new VehiculoEntity();


        vehiculoTest.setAnio_Fabricacion(1968);
        vehiculoTest.setPatente("ABC123");
        vehiculoTest.setMarca("TOYOTA");
        vehiculoTest.setModelo("COROLLA");
        vehiculoTest.setTipo("SEDAN");
        vehiculoTest.setTipoMotor("GASOLINA");
        vehiculoTest.setNumeroDeAsientos(5);

        VehiculoEntity vehiculoTest2=new VehiculoEntity();
        vehiculoTest2.setAnio_Fabricacion(1966);
        vehiculoTest2.setPatente("ACC123");
        vehiculoTest2.setMarca("SUZUKI");
        vehiculoTest2.setModelo("X2345");
        vehiculoTest2.setTipo("SEDAN");
        vehiculoTest2.setTipoMotor("GASOLINA");
        vehiculoTest2.setNumeroDeAsientos(5);

        ArrayList<VehiculoEntity> vehiculosLista=new ArrayList<>();

        vehiculosLista.add(vehiculoTest);
        vehiculosLista.add(vehiculoTest2);

        when(vehiculoRepository.findAll()).thenReturn(vehiculosLista);

        ArrayList<VehiculoEntity> resultado = vehiculoService.getVehiculos();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveVehiculo_thenCorrect(){
        VehiculoEntity vehiculoTest=new VehiculoEntity();


        vehiculoTest.setAnio_Fabricacion(1968);
        vehiculoTest.setPatente("ABC123");
        vehiculoTest.setMarca("TOYOTA");
        vehiculoTest.setModelo("COROLLA");
        vehiculoTest.setTipo("SEDAN");
        vehiculoTest.setTipoMotor("GASOLINA");
        vehiculoTest.setNumeroDeAsientos(5);

        when(vehiculoRepository.save(vehiculoTest)).thenReturn(vehiculoTest);

        VehiculoEntity vehiculoResponse=vehiculoService.saveVehiculo(vehiculoTest);

        assertEquals(vehiculoResponse,vehiculoTest);
    }

    @Test
    public void whenUpdateVehiculo_thenCorrect(){
        VehiculoEntity vehiculoTest=new VehiculoEntity();


        vehiculoTest.setAnio_Fabricacion(1968);
        vehiculoTest.setPatente("ABC123");
        vehiculoTest.setMarca("TOYOTA");
        vehiculoTest.setModelo("COROLLA");
        vehiculoTest.setTipo("SEDAN");
        vehiculoTest.setTipoMotor("GASOLINA");
        vehiculoTest.setNumeroDeAsientos(5);

        when(vehiculoRepository.save(vehiculoTest)).thenReturn(vehiculoTest);

        VehiculoEntity vehiculoUpdated=vehiculoService.updateVehiculo(vehiculoTest);

        assertEquals(vehiculoUpdated,vehiculoTest);
    }

    @Test
    public void testDeleteVehiculo() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = vehiculoService.deleteVehiculo(id);
        // Assert
        assertTrue(result);
        verify(vehiculoRepository, times(1)).deleteById(id);
    }

    @Test(expected= Exception.class)
    public void testDeleteVehiculoException() throws Exception {
        doThrow(IllegalStateException.class).when(vehiculoRepository).deleteById(1L);

        boolean response=vehiculoService.deleteVehiculo(1L);

    }
}
