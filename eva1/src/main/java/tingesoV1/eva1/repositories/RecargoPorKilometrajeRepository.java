package tingesoV1.eva1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tingesoV1.eva1.entities.RecargoPorKilometrajeEntity;

@Repository
public interface RecargoPorKilometrajeRepository extends JpaRepository<RecargoPorKilometrajeEntity,Long> {
    @Query(value = "SELECT porcentaje_recargo " + "FROM recargo_por_kilometraje rk " +
            "WHERE rk.kilometraje=:kilometraje AND rk.tipo_de_vehiculo=:tipoDeVehiculo", nativeQuery = true)
    Integer getRecargoByKilmetrajeYTipoDeVehiculo(@Param("kilometraje") String kilometraje, @Param("tipoDeVehiculo") String tipoDeVehiculo);
}
