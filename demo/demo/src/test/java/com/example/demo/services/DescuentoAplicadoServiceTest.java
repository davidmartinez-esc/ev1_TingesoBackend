package com.example.demo.services;

import com.example.demo.entities.DescuentoAplicadoEntity;
import com.example.demo.repositories.DescuentoAplicadoRepository;
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


public class DescuentoAplicadoServiceTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    private DescuentoAplicadoRepository descuentoAplicadoRepository;

    @InjectMocks
    private DescuentoAplicadoService descuentoAplicadoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
     public void whenGetDescuentoAplicado_thenCorrect(){

        DescuentoAplicadoEntity descuentoAplicadoTest=new DescuentoAplicadoEntity();


        descuentoAplicadoTest.setId(1L);
        descuentoAplicadoTest.setPorcentajeDescuento(25);
        descuentoAplicadoTest.setIdIngreso(1);
        descuentoAplicadoTest.setTipoDeDescuento("DESCUENTO POR NUMERO DE REPS");

        DescuentoAplicadoEntity descuentoAplicadoTest2=new DescuentoAplicadoEntity();

        descuentoAplicadoTest2.setId(2L);
        descuentoAplicadoTest2.setPorcentajeDescuento(25);
        descuentoAplicadoTest2.setIdIngreso(1);
        descuentoAplicadoTest2.setTipoDeDescuento("DESCUENTO POR DIA DE INGRESO");

        ArrayList<DescuentoAplicadoEntity> descuentoAplicadosLista=new ArrayList<>();

        descuentoAplicadosLista.add(descuentoAplicadoTest);
        descuentoAplicadosLista.add(descuentoAplicadoTest2);

        when(descuentoAplicadoRepository.findAll()).thenReturn(descuentoAplicadosLista);

        ArrayList<DescuentoAplicadoEntity> resultado = descuentoAplicadoService.getDescuentosAplicados();

        assertThat(2).isEqualTo(resultado.size());
    }

    @Test
    public void whenSaveDescuentoAplicado_thenCorrect(){
        DescuentoAplicadoEntity descuentoAplicadoTest=new DescuentoAplicadoEntity();


        descuentoAplicadoTest.setId(1L);
        descuentoAplicadoTest.setPorcentajeDescuento(25);
        descuentoAplicadoTest.setIdIngreso(1);
        descuentoAplicadoTest.setTipoDeDescuento("DESCUENTO POR NUMERO DE REPS");

        when(descuentoAplicadoRepository.save(descuentoAplicadoTest)).thenReturn(descuentoAplicadoTest);

        DescuentoAplicadoEntity descuentoAplicadoResponse=descuentoAplicadoService.saveDescuentoAplicado(descuentoAplicadoTest);

        assertEquals(descuentoAplicadoResponse,descuentoAplicadoTest);
    }

    @Test
    public void whenUpdateDescuentoAplicado_thenCorrect(){
        DescuentoAplicadoEntity descuentoAplicadoTest=new DescuentoAplicadoEntity();


        descuentoAplicadoTest.setId(1L);
        descuentoAplicadoTest.setPorcentajeDescuento(25);
        descuentoAplicadoTest.setIdIngreso(1);
        descuentoAplicadoTest.setTipoDeDescuento("DESCUENTO POR NUMERO DE REPS");



        when(descuentoAplicadoRepository.save(descuentoAplicadoTest)).thenReturn(descuentoAplicadoTest);

        DescuentoAplicadoEntity descuentoAplicadoUpdated=descuentoAplicadoService.updateDescuentoAplicado(descuentoAplicadoTest);

        assertEquals(descuentoAplicadoUpdated,descuentoAplicadoTest);
    }

    @Test
    public void testDeleteDescuentoAplicado() throws Exception {
        // Arrange
        Long id = 21L;

        // Act
        boolean result;

        result = descuentoAplicadoService.deleteDescuentoAplicado(id);
        // Assert
        assertTrue(result);
        verify(descuentoAplicadoRepository, times(1)).deleteById(id);
    }

    @Test(expected= Exception.class)
    public void testDeleteDescuentoAplicadoException() throws Exception {
        doThrow(IllegalStateException.class).when(descuentoAplicadoRepository).deleteById(1L);

        boolean response=descuentoAplicadoService.deleteDescuentoAplicado(1L);

    }
}
