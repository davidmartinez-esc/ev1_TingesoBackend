package tingesoV1.eva1.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tingesoV1.eva1.entities.IngresoARepEntity;

import tingesoV1.eva1.entities.IngresoARepEntity;
import tingesoV1.eva1.entities.RepEspecificaEntity;
import tingesoV1.eva1.repositories.IngresoARepRepository;
import tingesoV1.eva1.repositories.RepEspecificaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IngresoARepService {
    @Autowired
    RepEspecificaRepository repEspecificaRepository;
    @Autowired
    IngresoARepRepository ingresoARepRepository;

    public ArrayList<IngresoARepEntity> getReparaciones(){
        return (ArrayList<IngresoARepEntity>) ingresoARepRepository.findAll();
    }

    public IngresoARepEntity saveReparacion(IngresoARepEntity reparacion){
        return ingresoARepRepository.save(reparacion);
    }



  /*
    @Transactional
    public IngresoARepEntity saveIngresoARep(FormRegistroIngresoRep ingresoForm){
        IngresoARepEntity ingreso= new IngresoARepEntity();

        ingreso.setIdVehiculo(ingresoForm.getIdVehiculo());
        ingreso.setCostoTotal(ingresoForm.getCostoTotal());

        ingreso.setFechaIngreso(ingresoForm.getFechaIngreso());
        ingreso.setHoraIngreso(ingresoForm.getHoraIngreso());

        ingreso.setFechaSalida(ingresoForm.getFechaSalida());
        ingreso.setHoraSalida(ingresoForm.getHoraSalida());

        ingreso.setFechaRecogida(ingresoForm.getFechaRecogida());
        ingreso.setHoraRecogida(ingresoForm.getHoraRecogida());

        List<RepEspecificaEntity> reparacionesIndividuales=ingresoForm.getReparacionesAsociadas();
        int n=reparacionesIndividuales.size();

        RepEspecificaEntity reparacion;

        if (!reparacionesIndividuales.isEmpty()){
            System.out.println("NO ESTA VACIA");
            for (int i = 0; i < n; i++) {
                reparacion=reparacionesIndividuales.get(i);
                repEspecificaRepository.save(reparacion);
            }
        }

        return ingresoARepRepository.save(ingreso);
    }
    */


    public IngresoARepEntity updateIngresoARep(IngresoARepEntity ingresoARep) {
        return ingresoARepRepository.save(ingresoARep);
    }

    public boolean deleteIngresoARep(Long id) throws Exception {
        try{
            ingresoARepRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
