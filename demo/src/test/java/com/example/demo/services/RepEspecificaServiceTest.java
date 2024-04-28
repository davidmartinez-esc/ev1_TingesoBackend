package com.example.demo.services;

import com.example.demo.entities.RepEspecificaEntity;
import com.example.demo.repositories.RepEspecificaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class RepEspecificaServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private RepEspecificaRepository repEspecificaRepository;

    @InjectMocks
    private RepEspecificaService repEspecificaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetRepEspecifica_thenCorrect(){

        RepEspecificaEntity repEspecificaTest=new RepEspecificaEntity();


        repEspecificaTest.setId(12L);
        repEspecificaTest.setIdIngresoARep(1);
        repEspecificaTest.setPrecioDeLaReparacion(125000);
        repEspecificaTest.setNombreDeLaRep("REP ELECTRICA");



        RepEspecificaEntity repEspecificaTest2=new RepEspecificaEntity();

        repEspecificaTest2.setId(13L);
        repEspecificaTest2.setIdIngresoARep(2);
        repEspecificaTest2.setPrecioDeLaReparacion(122000);
        repEspecificaTest2.setNombreDeLaRep("REP ELECTRICA");


        ArrayList<RepEspecificaEntity> repEspecificasLista=new ArrayList<>();

        repEspecificasLista.add(repEspecificaTest);
        repEspecificasLista.add(repEspecificaTest2);

        when(repEspecificaRepository.findAll()).thenReturn(repEspecificasLista);

        ArrayList<RepEspecificaEntity> resultado = repEspecificaService.getAllReparacionesEspecificas();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveRepEspecifica_thenCorrect(){
        RepEspecificaEntity repEspecificaTest=new RepEspecificaEntity();


        repEspecificaTest.setId(12L);
        repEspecificaTest.setIdIngresoARep(1);
        repEspecificaTest.setPrecioDeLaReparacion(125000);
        repEspecificaTest.setNombreDeLaRep("REP ELECTRICA");

        when(repEspecificaRepository.save(repEspecificaTest)).thenReturn(repEspecificaTest);

        RepEspecificaEntity repEspecificaResponse= repEspecificaService.saveTipoDeRep(repEspecificaTest);

        assertEquals(repEspecificaResponse,repEspecificaTest);
    }

    @Test
    public void whenUpdateRepEspecifica_thenCorrect(){
        RepEspecificaEntity repEspecificaTest=new RepEspecificaEntity();


        repEspecificaTest.setId(12L);
        repEspecificaTest.setIdIngresoARep(1);
        repEspecificaTest.setPrecioDeLaReparacion(125000);
        repEspecificaTest.setNombreDeLaRep("REP ELECTRICA");



        when(repEspecificaRepository.save(repEspecificaTest)).thenReturn(repEspecificaTest);

        RepEspecificaEntity repEspecificaUpdated= repEspecificaService.updateRepEspecifica(repEspecificaTest);

        assertEquals(repEspecificaUpdated,repEspecificaTest);
    }

    @Test
    public void testDeleteRepEspecifica() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;


        result=repEspecificaService.deleteRepEspecifica(id);
        // Assert
        assertTrue(result);
        verify(repEspecificaRepository, times(1)).deleteById(id);
    }

    @Test(expected= Exception.class)
    public void testDeleteRepEspecificaException() throws Exception {
        doThrow(IllegalStateException.class).when(repEspecificaRepository).deleteById(1L);

        boolean response=repEspecificaService.deleteRepEspecifica(1L);

    }



    @Test
    public void wheGetRepEspecificaByIdIngreso_ThenReturnCorrect(){

        RepEspecificaEntity repEspecificaTest=new RepEspecificaEntity();


        repEspecificaTest.setId(12L);
        repEspecificaTest.setIdIngresoARep(1);
        repEspecificaTest.setPrecioDeLaReparacion(125000);
        repEspecificaTest.setNombreDeLaRep("REP ELECTRICA");



        RepEspecificaEntity repEspecificaTest2=new RepEspecificaEntity();

        repEspecificaTest2.setId(13L);
        repEspecificaTest2.setIdIngresoARep(1);
        repEspecificaTest2.setPrecioDeLaReparacion(122000);
        repEspecificaTest2.setNombreDeLaRep("REP ELECTRICA");


        List<RepEspecificaEntity> repEspecificasLista=new ArrayList<>();

        repEspecificasLista.add(repEspecificaTest);
        repEspecificasLista.add(repEspecificaTest2);

        when(repEspecificaRepository.findByIdIngresoARep(1)).thenReturn(repEspecificasLista);

        List<RepEspecificaEntity> resultado = repEspecificaService.getRepEspecificaByIdIngreso(1);

        assertThat(2).isEqualTo(resultado.size());
    }
}
