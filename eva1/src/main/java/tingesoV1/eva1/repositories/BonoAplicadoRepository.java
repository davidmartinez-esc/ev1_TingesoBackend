package tingesoV1.eva1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tingesoV1.eva1.entities.BonoAplicadoEntity;

import java.util.List;

@Repository
public interface BonoAplicadoRepository extends JpaRepository<BonoAplicadoEntity,Long> {

    /*
    @Query(value = "SELECT * FROM extra_hours WHERE extra_hours.rut = :rut AND date_part('year',hours.date)=:year AND MONTH(extra_hours.date)=:month", nativeQuery = true)
    List<ExtraHoursEntity> getExtraHoursByRutYearMonth(@Param("rut") String rut, @Param("year") int year, @Param("month") int month);
    */
    /*
    * SELECT COUNT(b.id) FROM bono_aplicado b JOIN ingreso_a_rep i ON i.id=b.idIngreso WHERE date.part('month',fechaIngreso)=:mes
    * */

    @Query(value = "SELECT COUNT(b.id) " +
            "FROM bono_aplicado b " +
            "JOIN ingreso_a_rep i ON i.id=b.id_ingreso " +
            "JOIN vehiculo v ON i.id_vehiculo=v.id"+
            "WHERE date.part('month',i.fecha_ingreso)=:mes AND v.marca=:marca", nativeQuery = true)
    Integer contarBonosPorMes(@Param("mes") int mes,@Param("marca") String marca);



}
