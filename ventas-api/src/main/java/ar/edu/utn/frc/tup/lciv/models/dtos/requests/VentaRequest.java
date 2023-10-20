package ar.edu.utn.frc.tup.lciv.models.dtos.requests;

import ar.edu.utn.frc.tup.lciv.models.DetalleVenta;
import ar.edu.utn.frc.tup.lciv.models.FormaEntrega;
import ar.edu.utn.frc.tup.lciv.models.TipoVenta;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequest {
    @NotNull
    private Date fecha;
    @NotNull
    private Long id_cliente;
    @NotNull
    private Long tipo_venta;
    @NotNull
    private Long forma_entrega;
    @NotNull
    private Date fecha_entrega;
    @NotNull
    private Long id_vendedor;
    @NotNull
    @NotEmpty
    private List<DetalleVenta> detalles;
}
