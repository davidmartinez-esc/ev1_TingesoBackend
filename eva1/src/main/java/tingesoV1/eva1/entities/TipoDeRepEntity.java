package tingesoV1.eva1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_de_reparacion_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDeRepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombreDeLaRep;
    private String precioDeLaReparacion;
}
