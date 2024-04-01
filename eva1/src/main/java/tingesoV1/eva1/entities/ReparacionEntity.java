package tingesoV1.eva1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reparacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparacionEntity {
    //FALTA CONSTRUCTOR PROPIO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int montoTotal;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Temporal(TemporalType.TIME)
    private Date horaIngreso;


    @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    @Temporal(TemporalType.TIME)
    private Date horaSalida;

    @Temporal(TemporalType.DATE)
    private Date fechaRecogida;

    @Temporal(TemporalType.TIME)
    private Date horaRecogida;
}
