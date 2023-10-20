package ar.edu.utn.frc.tup.lciv.reporitories;

import ar.edu.utn.frc.tup.lciv.entities.PresupuestoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPresupuestoRepository extends JpaRepository<PresupuestoEntity,Long> {
}
