package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.repositories.BonoAplicadoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class AplicadosAPrecioNoTabuladosService {
    private final int descuentosDispToyota=5;
    private final int montoBonoToyota=70000;
    private final int descuentosDispFord=2;
    private final int montoBonoForda=50000;
    private final int descuentosDispHyundai=2;
    private final int montoBonoHyundai=30000;
    private final int descuentosDispHonda=7;
    private final int montoBonoHonda=40000;

    @Autowired
    BonoAplicadoRepository bonoAplicadoRepository;

    public boolean disponibilidadDescuentoPorHoraIngreso(LocalTime horaIngreso, Date fechaIngreso){
        int diaDeIngreso;
        boolean repsonse=false;

        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaIngreso);
        diaDeIngreso=cal.get(Calendar.DAY_OF_WEEK);

        LocalTime limiteInferior = LocalTime.of(9, 0);
        LocalTime limiteSuperior = LocalTime.of(12,0);

        if (horaIngreso.isAfter(limiteInferior) && horaIngreso.isBefore(limiteSuperior)){
            if (diaDeIngreso==2 || diaDeIngreso==5){
                return repsonse=true;
            }
        }
        return repsonse;


    }

    public int recargoPorAtrasoEnRecoger(Date fechaSalida,Date fechaRecogida){
        int porecentajeRecargo=5;
        long difEnMilisegundos = Math.abs(fechaRecogida.getTime() - fechaSalida.getTime());
        long dif = TimeUnit.DAYS.convert(difEnMilisegundos, TimeUnit.MILLISECONDS);

        int difInt= (int) dif;
       return porecentajeRecargo*difInt;
    }

    public void descuentoPorBono(String tipoDeMoto,int mes){
        int vecesPorMes=20882;

        vecesPorMes=bonoAplicadoRepository.contarBonosPorMes(mes);


        return;
    }
}
