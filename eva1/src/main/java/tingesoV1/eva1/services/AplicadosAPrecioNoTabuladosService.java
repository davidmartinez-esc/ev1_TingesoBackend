package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.repositories.BonoAplicadoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
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
        /*
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaIngreso);
        diaDeIngreso=cal.get(Calendar.DAY_OF_WEEK);
        */

        TimeZone tz = TimeZone.getTimeZone("GMT-4");
        Locale loc = new Locale("cl", "CL", "CL");
        Calendar calendar =new GregorianCalendar(tz);
        calendar.setTime(fechaIngreso);

        int dia=calendar.get(Calendar.DAY_OF_WEEK);


        LocalTime limiteInferior = LocalTime.of(9, 0);
        LocalTime limiteSuperior = LocalTime.of(12,0);

        if (horaIngreso.isAfter(limiteInferior) && horaIngreso.isBefore(limiteSuperior)){
            if (dia==3 || dia==5){
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

        int difInt= (int) dif;
       return porecentajeRecargo*difInt;
    }

    public int descuentoPorBono(String marca,int mes){
        int vecesPorMes=20882;

        vecesPorMes=bonoAplicadoRepository.contarBonosPorMes(mes,marca);

        if (vecesPorMes<descuentosDispToyota && marca.equals("TOYOTA")){
            return montoBonoToyota;
        } else if (vecesPorMes<descuentosDispFord && marca.equals("FORD")){
            return montoBonoFord;
        } else if (vecesPorMes<descuentosDispHyundai && marca.equals("HYUNDAY")) {
            return montoBonoHyundai;
        }else if (vecesPorMes<descuentosDispHonda && marca.equals("HONDA")) {
            return montoBonoHonda;
        }
        return 0;
    }
}
