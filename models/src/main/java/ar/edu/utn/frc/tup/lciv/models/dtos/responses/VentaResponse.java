package ar.edu.utn.frc.tup.lciv.models.dtos.responses;


import ar.edu.utn.frc.tup.lciv.models.DetalleVenta;
import ar.edu.utn.frc.tup.lciv.models.EstadoVenta;
import ar.edu.utn.frc.tup.lciv.models.FormaEntrega;
import ar.edu.utn.frc.tup.lciv.models.TipoVenta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data@Component
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponse {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "UTC")
    private Date fecha;
    private Long id_cliente;
    private TipoVenta tipo_venta;
    private FormaEntrega forma_entrega;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "UTC")
    private Date fecha_entrega;
    private Long id_vendedor;
    private List<DetalleVenta> detalles;
    private BigDecimal total;
    private EstadoVenta estado;
}
