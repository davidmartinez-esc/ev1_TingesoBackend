package tingesoV1.eva1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bono_aplicado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonoAplicadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private int monto;

    private int idIngreso;
}
