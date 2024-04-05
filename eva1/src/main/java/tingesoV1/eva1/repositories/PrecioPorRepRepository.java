package tingesoV1.eva1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tingesoV1.eva1.entities.PrecioPorRepEntity;

import java.util.List;

public interface PrecioPorRepRepository extends JpaRepository<PrecioPorRepEntity,Long> {
    @Query(value = "SELECT Gasolina FROM extra_hours WHERE extra_hours.rut = :rut AND YEAR(extra_hours.date)=:year AND MONTH(extra_hours.date)=:month", nativeQuery = true)
    List<ExtraHoursEntity> getExtraHoursByRutYearMonth(@Param("rut") String rut, @Param("year") int year, @Param("month") int month,@Param("target") String target);
}
