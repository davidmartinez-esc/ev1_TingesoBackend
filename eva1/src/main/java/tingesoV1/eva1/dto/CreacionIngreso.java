package tingesoV1.eva1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tingesoV1.eva1.entities.RepEspecificaEntity;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreacionIngreso {
    private Long id;

    private int idVehiculo;

    private int costoTotal;

    private Date fechaIngreso;

    private String horaIngreso;

    private Date fechaSalida;

    private String horaSalida;

    private Date fechaRecogida;

    private String horaRecogida;

}
