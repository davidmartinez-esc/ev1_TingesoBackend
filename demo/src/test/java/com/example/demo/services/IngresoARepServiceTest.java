package com.example.demo.services;

import com.example.demo.entities.IngresoARepEntity;
import com.example.demo.repositories.IngresoARepRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class IngresoARepServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private IngresoARepRepository ingresoARepRepository;

    @InjectMocks
    private IngresoARepService ingresoARepService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetIngresoARep_thenCorrect(){
        Date fechaEjemplo=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 31, 59, 59, 59);
        fechaEjemplo=calendar.getTime();

        LocalTime horaEjemplo=LocalTime.parse("12:12");

        IngresoARepEntity ingresoARepTest=new IngresoARepEntity();

        ingresoARepTest.setId(1L);

        ingresoARepTest.setFechaIngreso(fechaEjemplo);
        ingresoARepTest.setHoraIngreso(horaEjemplo);
        ingresoARepTest.setFechaRecogida(fechaEjemplo);
        ingresoARepTest.setHoraRecogida(horaEjemplo);
        ingresoARepTest.setFechaSalida(fechaEjemplo);
        ingresoARepTest.setHoraSalida(horaEjemplo);

        ingresoARepTest.setIdVehiculo(1);
        ingresoARepTest.setCostoTotal(1500000);

        IngresoARepEntity ingresoARepTest2=new IngresoARepEntity();

        ingresoARepTest2.setId(2L);


        ingresoARepTest2.setFechaIngreso(fechaEjemplo);
        ingresoARepTest2.setHoraIngreso(horaEjemplo);
        ingresoARepTest2.setFechaRecogida(fechaEjemplo);
        ingresoARepTest2.setHoraRecogida(horaEjemplo);
        ingresoARepTest2.setFechaSalida(fechaEjemplo);
        ingresoARepTest2.setHoraSalida(horaEjemplo);

        ingresoARepTest2.setIdVehiculo(2);
        ingresoARepTest2.setCostoTotal(1500000);

        ArrayList<IngresoARepEntity> ingresoARepsLista=new ArrayList<>();

        ingresoARepsLista.add(ingresoARepTest);
        ingresoARepsLista.add(ingresoARepTest2);

        when(ingresoARepRepository.findAll()).thenReturn(ingresoARepsLista);

        ArrayList<IngresoARepEntity> resultado = ingresoARepService.getReparaciones();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveIngresoARep_thenCorrect(){
        Date fechaEjemplo=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 31, 59, 59, 59);
        fechaEjemplo=calendar.getTime();

        LocalTime horaEjemplo=LocalTime.parse("12:12");

        IngresoARepEntity ingresoARepTest=new IngresoARepEntity();

        ingresoARepTest.setId(1L);

        ingresoARepTest.setFechaIngreso(fechaEjemplo);
        ingresoARepTest.setHoraIngreso(horaEjemplo);
        ingresoARepTest.setFechaRecogida(fechaEjemplo);
        ingresoARepTest.setHoraRecogida(horaEjemplo);
        ingresoARepTest.setFechaSalida(fechaEjemplo);
        ingresoARepTest.setHoraSalida(horaEjemplo);
        ingresoARepTest.setId(1L);
        ingresoARepTest.setCostoTotal(1500000);

        when(ingresoARepRepository.save(ingresoARepTest)).thenReturn(ingresoARepTest);

        IngresoARepEntity ingresoARepResponse=ingresoARepService.saveReparacion(ingresoARepTest);

        assertEquals(ingresoARepResponse,ingresoARepTest);
    }

    @Test
    public void whenUpdateIngresoARep_thenCorrect(){
        Date fechaEjemplo=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 31, 59, 59, 59);
        fechaEjemplo=calendar.getTime();

        LocalTime horaEjemplo=LocalTime.parse("12:12");

        IngresoARepEntity ingresoARepTest=new IngresoARepEntity();

        ingresoARepTest.setId(1L);

        ingresoARepTest.setFechaIngreso(fechaEjemplo);
        ingresoARepTest.setHoraIngreso(horaEjemplo);
        ingresoARepTest.setFechaRecogida(fechaEjemplo);
        ingresoARepTest.setHoraRecogida(horaEjemplo);
        ingresoARepTest.setFechaSalida(fechaEjemplo);
        ingresoARepTest.setHoraSalida(horaEjemplo);
        ingresoARepTest.setId(1L);
        ingresoARepTest.setCostoTotal(1500000);
        when(ingresoARepRepository.save(ingresoARepTest)).thenReturn(ingresoARepTest);

        IngresoARepEntity ingresoARepUpdated=ingresoARepService.updateIngresoARep(ingresoARepTest);

        assertEquals(ingresoARepUpdated,ingresoARepTest);
    }

    @Test
    public void testDeleteIngresoARep() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = ingresoARepService.deleteIngresoARep(id);
        // Assert
        assertTrue(result);
        verify(ingresoARepRepository, times(1)).deleteById(id);
    }

    @Test(expected= Exception.class)
    public void testDeleteIngresoARepException() throws Exception {
        doThrow(IllegalStateException.class).when(ingresoARepRepository).deleteById(1L);

        boolean response=ingresoARepService.deleteIngresoARep(1L);

    }

    @Test
    public void whenGetByIdVehiculo_thenCorrect(){
        Date fechaEjemplo=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 31, 59, 59, 59);
        fechaEjemplo=calendar.getTime();

        LocalTime horaEjemplo=LocalTime.parse("12:12");

        IngresoARepEntity ingresoARepTest=new IngresoARepEntity();

        ingresoARepTest.setId(1L);

        ingresoARepTest.setFechaIngreso(fechaEjemplo);
        ingresoARepTest.setHoraIngreso(horaEjemplo);
        ingresoARepTest.setFechaRecogida(fechaEjemplo);
        ingresoARepTest.setHoraRecogida(horaEjemplo);
        ingresoARepTest.setFechaSalida(fechaEjemplo);
        ingresoARepTest.setHoraSalida(horaEjemplo);
        ingresoARepTest.setIdVehiculo(1);
        ingresoARepTest.setCostoTotal(1500000);

        List<IngresoARepEntity> listaBase=new ArrayList<>();
        listaBase.add(ingresoARepTest);

        when(ingresoARepRepository.findByIdVehiculo(1)).thenReturn(listaBase);

        List<IngresoARepEntity> ingresoARepUpdated=ingresoARepService.getReparacionesByIdVehiculo(1);

        assertEquals(ingresoARepUpdated,listaBase);
    }
}
