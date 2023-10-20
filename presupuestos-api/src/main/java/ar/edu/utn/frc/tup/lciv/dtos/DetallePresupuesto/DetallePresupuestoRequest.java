package ar.edu.utn.frc.tup.lciv.dtos.DetallePresupuesto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePresupuestoRequest {
    private Long id;
    private String descripcion;
    private Integer cantidad;
    private String unidad;
}
