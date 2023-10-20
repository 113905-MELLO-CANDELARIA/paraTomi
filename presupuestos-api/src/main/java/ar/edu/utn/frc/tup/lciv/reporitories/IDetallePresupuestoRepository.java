package ar.edu.utn.frc.tup.lciv.reporitories;

import ar.edu.utn.frc.tup.lciv.entities.DetallePresupuestoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetallePresupuestoRepository extends JpaRepository<DetallePresupuestoEntity, Long> {
}
