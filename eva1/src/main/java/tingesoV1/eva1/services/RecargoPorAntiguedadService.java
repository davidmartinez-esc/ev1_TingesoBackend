package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.entities.VehiculoEntity;
import tingesoV1.eva1.repositories.RecargoPorAntiguedadRepository;

import java.util.ArrayList;
import java.util.Calendar;

@Service

public class RecargoPorAntiguedadService {

    @Autowired
    RecargoPorAntiguedadRepository recargoPorAntiguedadRepository;

    public ArrayList<RecargoPorAntiguedadEntity> getRecargosPorAntiguedad(){
        return (ArrayList<RecargoPorAntiguedadEntity>) recargoPorAntiguedadRepository.findAll();
    }

    public RecargoPorAntiguedadEntity saveRecargoPorAntiguedad(RecargoPorAntiguedadEntity recargoPorAntiguedad){
        return recargoPorAntiguedadRepository.save(recargoPorAntiguedad);
    }


    public RecargoPorAntiguedadEntity updateRecargoPorAntiguedad(RecargoPorAntiguedadEntity recargoPorAntiguedad) {
        return recargoPorAntiguedadRepository.save(recargoPorAntiguedad);
    }

    public boolean deleteRecargoPorAntiguedad(Long id) throws Exception {
        try{
            recargoPorAntiguedadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    private String getAntiguedadInString(int anioFabricacion){
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int antiguedad=year-anioFabricacion;

        if (antiguedad>=0 && antiguedad<=5 ){
            return "0-5";
        } else if (antiguedad >= 6 && antiguedad <= 10) {
            return "6-10";
        } else if (antiguedad >= 11 && antiguedad <= 15) {
            return "11-15";
        }else {
            return "16-MAS";}


    }
    public Integer getRecargoPorAntiguedadByTipoDeMotor(VehiculoEntity vehiculo){
        String antiguedadString= getAntiguedadInString(vehiculo.getAnio_Fabricacion());

        return recargoPorAntiguedadRepository.getRecargoByAntiguedadYTipoDeMotor(antiguedadString,vehiculo.getTipo());

    }
}
