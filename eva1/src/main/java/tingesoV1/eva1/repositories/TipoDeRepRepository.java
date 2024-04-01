package tingesoV1.eva1.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingesoV1.eva1.entities.TipoDeRepEntity;

import java.util.List;

@Repository
public interface TipoDeRepRepository extends JpaRepository<TipoDeRepEntity, Long> {

}
