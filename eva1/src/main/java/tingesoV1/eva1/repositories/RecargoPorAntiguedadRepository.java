package tingesoV1.eva1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tingesoV1.eva1.entities.RecargoPorAntiguedadEntity;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;

public interface RecargoPorAntiguedadRepository extends JpaRepository<RecargoPorAntiguedadEntity,Long> {
    @Query(value = "SELECT porcentaje_recargo " + "FROM recargo_por_antiguedad ra " +
            "WHERE ra.antiguedad=:antiguedad AND ra.tipo_de_vehiculo=:tipoDeVehiculo", nativeQuery = true)
    Integer getRecargoByAntiguedadYTipoDeMotor(@Param("antiguedad") String antiguedad, @Param("tipoDeVehiculo") String tipoDeVehiculo);
}
