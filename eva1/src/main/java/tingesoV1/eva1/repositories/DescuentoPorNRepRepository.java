package tingesoV1.eva1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingesoV1.eva1.entities.DescuentoPorNRepEntity;
@Repository
public interface DescuentoPorNRepRepository extends JpaRepository<DescuentoPorNRepEntity,Long> {
}
