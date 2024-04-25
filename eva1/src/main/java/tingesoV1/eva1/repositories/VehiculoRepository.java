package tingesoV1.eva1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingesoV1.eva1.entities.VehiculoEntity;

import java.util.ArrayList;
@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity,Long> {

}
