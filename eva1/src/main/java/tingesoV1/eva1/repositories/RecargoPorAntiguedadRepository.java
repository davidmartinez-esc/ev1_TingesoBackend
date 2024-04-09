package tingesoV1.eva1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;

public interface RecargoPorAntiguedadRepository extends JpaRepository<RecargoPorAntiguedadEntity,Long> {
}
