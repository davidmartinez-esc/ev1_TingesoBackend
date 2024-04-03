package tingesoV1.eva1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "reparacion_especifica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepEspecificaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombreDeLaRep;
    private String precioDeLaReparacion;
}
