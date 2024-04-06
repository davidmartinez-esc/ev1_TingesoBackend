package tingesoV1.eva1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tingesoV1.eva1.entities.RepEspecificaEntity;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FormRegistroIngresoRep {

    private Long id;

    private int idVehiculo;

    private int costoTotal;

    private Date fechaIngreso;

    private Date horaIngreso;

    private Date fechaSalida;

    private Date horaSalida;

    private Date fechaRecogida;

    private Date horaRecogida;

    private List<RepEspecificaEntity> reparacionesAsociadas;
}
