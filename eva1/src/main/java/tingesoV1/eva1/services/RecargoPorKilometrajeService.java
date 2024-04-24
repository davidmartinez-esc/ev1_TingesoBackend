package tingesoV1.eva1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;
import tingesoV1.eva1.entities.VehiculoEntity;
import tingesoV1.eva1.repositories.RecargoPorKilometrajeRepository;

import java.util.ArrayList;
import java.util.Calendar;

@Service
public class RecargoPorKilometrajeService {

    @Autowired
    RecargoPorKilometrajeRepository recargoPorKilometrajeRepository;

    public ArrayList<RecargoPorKilometrajeEntity> getRecargosPorKilometraje(){
        return (ArrayList<RecargoPorKilometrajeEntity>) recargoPorKilometrajeRepository.findAll();
    }

    public RecargoPorKilometrajeEntity saveRecargoPorKilometraje(RecargoPorKilometrajeEntity recargoPorKilometraje){
        return recargoPorKilometrajeRepository.save(recargoPorKilometraje);
    }


    public RecargoPorKilometrajeEntity updateRecargoPorKilometraje(RecargoPorKilometrajeEntity recargoPorKilometraje) {
        return recargoPorKilometrajeRepository.save(recargoPorKilometraje);
    }

    public boolean deleteRecargoPorKilometraje(Long id) throws Exception {
        try{
            recargoPorKilometrajeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    private String getKilometrajeInString(int kilometraje){
        if (kilometraje>=0 && kilometraje<=5000 ){
            return "0-5.000";
        } else if (kilometraje >= 5001 && kilometraje <= 12000) {
            return "5.001-12.000";
        } else if (kilometraje >= 12001 && kilometraje <= 25000) {
            return "12.001-25.000";
        } else if (kilometraje >= 25001 && kilometraje <= 40000) {
            return "25.001-40.000";
        }else {
            return "40.000–MAS";
        }
    }

    public Integer getRecargoPorAntiguedadByTipoDeMotor(int kilometraje,VehiculoEntity vehiculo){
        String kilmetrajeString= getKilometrajeInString(kilometraje);

        return recargoPorKilometrajeRepository.getRecargoByKilmetrajeYTipoDeMotor(kilmetrajeString,vehiculo.getTipo());

    }

}
