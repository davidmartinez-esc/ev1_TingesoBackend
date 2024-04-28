package com.example.demo.services;

import com.example.demo.repositories.BonoAplicadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@Service
public class AplicadosAPrecioNoTabuladosService {
    private final int descuentosDispToyota=5;
    private final int montoBonoToyota=70000;
    private final int descuentosDispFord=2;
    private final int montoBonoFord=50000;
    private final int descuentosDispHyundai=2;
    private final int montoBonoHyundai=30000;
    private final int descuentosDispHonda=7;
    private final int montoBonoHonda=40000;

    @Autowired
    BonoAplicadoRepository bonoAplicadoRepository;



    public Boolean disponibilidadDescuentoPorHoraIngreso(LocalTime horaIngreso, Date fechaIngreso){
        int diaDeIngreso;
        Boolean response=false;




        Calendar calendario= new GregorianCalendar();
        calendario.setTime(fechaIngreso);

        int dia=calendario.get(Calendar.DAY_OF_WEEK);
        System.out.println(dia);

        LocalTime limiteInferior = LocalTime.of(9, 0);
        LocalTime limiteSuperior = LocalTime.of(12,0);

        if (horaIngreso.isAfter(limiteInferior) && horaIngreso.isBefore(limiteSuperior)){
            if (dia==2 || dia==5){
                return response=true;
            }
            return response=false;
        }
        return null;


    }


    public int recargoPorAtrasoEnRecoger(Date fechaSalida,Date fechaRecogida){
        int porecentajeRecargo=5;
        long difEnMilisegundos = Math.abs(fechaRecogida.getTime() - fechaSalida.getTime());
        long dif = TimeUnit.DAYS.convert(difEnMilisegundos, TimeUnit.MILLISECONDS);

        int diasDeAtraso= (int) dif;
       return porecentajeRecargo*diasDeAtraso;
    }

    public int descuentoPorBono(String marca,int mes){
        int vecesQueBonoFueEntregadoXMes=20882;

        vecesQueBonoFueEntregadoXMes=bonoAplicadoRepository.contarBonosPorMes(mes,marca);

        if (vecesQueBonoFueEntregadoXMes<descuentosDispToyota && marca.equals("TOYOTA")){
            return montoBonoToyota;
        } else if (vecesQueBonoFueEntregadoXMes<descuentosDispFord && marca.equals("FORD")){
            return montoBonoFord;
        } else if (vecesQueBonoFueEntregadoXMes<descuentosDispHyundai && marca.equals("HYUNDAI")) {
            return montoBonoHyundai;
        }else if (vecesQueBonoFueEntregadoXMes<descuentosDispHonda && marca.equals("HONDA")) {
            return montoBonoHonda;
        }
        return 0;
    }
}
